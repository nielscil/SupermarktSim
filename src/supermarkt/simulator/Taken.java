package supermarkt.simulator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//javaDoc volledig ingevuld
/**
 * klasse die de taken/route bij houdt van de klanten en personeel
 * @author Niels
 */
public class Taken {

        /**
        * Taken die uitgevoerd kunnen worden door zowel personeel als klant
        */
        public static enum Taak {Pad1, Pad2, Pad3, Pad4, Afdeling1, Afdeling1_Personeel, Afdeling2, Afdeling2_Personeel, Voordeelstraat, Kassa1, Kassa1_Personeel, Kassa2, Kassa2_Personeel, Kassa3, Kassa3_Personeel, Kassa4, Kassa4_Personeel, Magazijn,Vrachtwagen,Uitgang,Pauze};
	private Taak taak;
        private List<Point> route;
        
        /**
         * aanmaken van een taak
         * @param taak die de klant/personeelslid moet uitvoeren
         */
        public Taken(Taak taak)
        {
            this.taak = taak;
        }
        
        /**
         * Geeft eindpunt van de taak
         * @return het eindpunt
         */
        public Point getEindPunt()
        {
            switch(taak)
                {
                    case Pad1:
                        return new Point(8,8);
                    case Pad2:
                        return new Point(8,12);
                    case Pad3:
                        return new Point(8,16);
                    case Pad4:
                        return new Point(8,20);
                    case Afdeling1:
                        return new Point(5,5);
                    case Afdeling1_Personeel:
                        return new Point(5,3);
                    case Afdeling2:
                        return new Point(25,11);
                    case Afdeling2_Personeel:
                        return new Point(27,11);
                    case Voordeelstraat:
                        return new Point(19,13);
                    case Kassa1:
                        return new Point(27,26);
                    case Kassa1_Personeel:
                        return new Point(29,26);
                    case Kassa2:
                        return new Point(23,26);
                    case Kassa2_Personeel:
                        return new Point(25,26);
                    case Kassa3:
                        return new Point(19,26);
                    case Kassa3_Personeel:
                        return new Point(21,26);
                    case Kassa4:
                        return new Point(15,26);
                    case Kassa4_Personeel:
                        return new Point(17,26);
                    case Magazijn:
                        return new Point(18,1);
                    case Vrachtwagen:
                        return new Point(23,1);
                    case Pauze:
                        return new Point(19,4);
                    default:
                        return new Point(1,31);    
                }
        }
        /**
         * Geeft de taak terug
         * @return de taak
         */
        public Taak getTaak()
        {
            return this.taak;
        }
        
        /**
         * haalt het volgende punt op in de route
         * @param begin begin punt
         * @return volgende punt van de route
         * @throws Exception wanneer er geen route gevonden wordt
         */
        public Point getTaakBeschrijving(Point begin) throws Exception
        {
            if(route == null)
            {
                calculatePath(begin, getEindPunt());
            }
            if(route == null)
                throw new Exception("Geen route gevonden");
            if(route.isEmpty())
                return getEindPunt();
            Point next = route.get(0);
            route.remove(0);
            return next;
        }
        
        /**
         * Maakt nieuw pathtracking aan en zoekt een route
         * @param begin begin punt van route
         * @param end eindpunt van route
         */
        private void calculatePath(Point begin,Point end)
        {
            //begin = p;
            PathTracking path = new PathTracking(Controller.bord, begin, end);
            route = path.solve();
        }
        
        /**
         * Klasse waarmee de route wordt berekend
         */
        class PathTracking
        {
            private Node[][] map;
            private final Point begin;
            private final Point end;
            private ArrayList<Node> closed = new ArrayList<>();
            private SortedList open = new SortedList();
            
            /**
             * Maak een pathtracking object aan
             * @param bord de kaart
             * @param begin begin punt
             * @param end eind punt
             */
            public PathTracking(BordPunt[][] bord, Point begin, Point end)
            {
                this.begin = begin;
                this.end = end;
                map = new Node[bord.length][bord[0].length];
                for(int i = 0; i < bord.length; i++)
                {
                    for(int j = 0; j < bord[i].length; j++)
                    {
                        int item = bord[i][j].getItem();
                        map[i][j] = new Node(item != 0 && item != 9 && item != 10,i,j);
                    }
                }
            }
            
            /**
             * Zoekt de route met de gegeven waardes
             * @return lijst van punten die de route aangeven
             */
            public List<Point> solve()
            {
                if(isBlocked(end.x, end.y))
                    return null;
                map[begin.x][begin.y].cost = 0;
                map[begin.x][begin.y].depth = 0;
                closed.clear();
                open.clear();
                open.add(map[begin.x][begin.y]);
                map[end.x][end.y].parent = null;
                while(open.size() != 0)
                {
                    Node current = getFirstInOpen();
                    if(current == map[end.x][end.y])
                        break;
                    open.remove(current);
                    closed.add(current);
                    for(int x=-1; x < 2; x++)
                    {
                        for(int y =-1; y < 2; y++)
                        {
                            if(x == 0 && y ==0)
                                continue;
                            if((x != 0) && (y != 0))
                                continue;
                            int xp = x + current.x;
                            int yp = y + current.y;
                            if(isValidLocation(begin.x, begin.y, xp, yp))
                            {
                                int nextStepCost = current.cost + getMovementCost(current.x, current.y, x, y);
                                Node neigbour = map[xp][yp];
                                if(nextStepCost < neigbour.cost)
                                {
                                    if(inOpenList(neigbour))
                                        open.remove(neigbour);
                                    if(inClosedList(neigbour))
                                        closed.remove(neigbour);
                                }
                                if(!inOpenList(neigbour) && !inClosedList(neigbour))
                                {
                                    neigbour.cost = nextStepCost;
                                    neigbour.heuristic = getCost(xp, yp, end.x, end.y);
                                    neigbour.setParent(current);
                                    open.add(neigbour);
                                }
                            }
                        }
                    }
                }
                if(map[end.x][end.y].parent == null)
                {
                    return null;
                }
                List<Point> path = new ArrayList<>();
                Node target = map[end.x][end.y];
                while(target != map[begin.x][begin.y])
                {
                    path.add(0, new Point(target.x,target.y));
                    target = target.parent;
                }
                return path;
            }
            
            /**
             * kijkt of op dit blok wandelbaar is
             * @param x waarde van x-as
             * @param y waarde van y-as
             * @return true wanneer het niet wandelbaar is en anders false
             */
            private boolean isBlocked(int x,int y)
            {
                return map[x][y].blocked;
            }
            
            /**
             * Haalt eerste Node uit de open lijst
             * @return  Node
             */
            private Node getFirstInOpen()
            {
                return (Node)open.first();
            }
            
            /**
             * Haalt het aantal stappen (kosten) op
             * @param sx start waarde x-as
             * @param sy start waarde y-as
             * @param tx doel waarde x-as
             * @param ty doel waarde y-as
             * @return stappen
             */
            public int getMovementCost(int sx, int sy, int tx, int ty) 
            {
		return 1;
            }
            /**
             * Kijkt of Node in de closed list zit
             * @param node gezochte node
             * @return true wanneer hij erin zit, anders false
             */
            private boolean inClosedList(Node node) 
            {
		return closed.contains(node);
            }
            
            /**
             * Kijkt of Node in open list zit
             * @param node gezochte node
             * @return true wanneer hij erin zit, anders false
             */
            private boolean inOpenList(Node node) 
            {
		return open.contains(node);
            }
            
            /**
             * Kijkt of de de locatie mag is
             * @param sx start x waarde
             * @param sy start y waarde
             * @param x huidige x waarde
             * @param y huidige y waarde
             * @return true wanneer locatie goed is, anders false
             */
            private boolean isValidLocation(int sx, int sy, int x, int y) 
            {
		boolean invalid = (x < 0) || (y < 0) || (x >= map.length) || (y >= map[0].length);
		
		if ((!invalid) && ((sx != x) || (sy != y))) 
                {
			invalid = isBlocked(x, y);
		}
		
		return !invalid;
            }
            
            /**
             * Haalt Heuristics kosten op
             * @param x huidige x waarde
             * @param y huidige y waarde
             * @param tx doel x waarde
             * @param ty doel u waarde
             * @return  de kosten
             */
            private float getCost(int x,int y,int tx,int ty)
            {
                float dx = tx - x;
                float dy = ty - y;
                return (float)(Math.sqrt((dx * dx)+(dy * dy)));
            }
            
            /**
             * Node klasse voor het zoeken naar routes
             */
            class Node implements Comparable
            {
                private int x;
                private int y;
                private int cost;
                private Node parent;
                private float heuristic;
                private int depth;
                public boolean blocked = false;
                 
                /**
                 * Aanmaken van een Node
                 * @param blocked is Node niet wandelbaar
                 * @param x waarde x-as
                 * @param y waarde y-as
                 */
                public Node(boolean blocked,int x, int y)
                {
                    this.x = x;
                    this.y = y;
                    this.blocked = blocked;
                }
                
                /**
                 * Zet de parent van deze Node
                 * @param parent parent Node
                 */
                public void setParent(Node parent)
                {
                    depth = parent.depth + 1;
                    this.parent = parent;
                }
                
                /**
                 * Vergelijkt deze Node met een andere
                 * @param other andere Node
                 * @return -1 als deze kleiner is dan andere, 1 als deze groter is dan andere, 0 als ze gelijk zijn
                 */
                @Override
                public int compareTo(Object other)
                {
                    Node o = (Node)other;
                    float f = heuristic + cost;
                    float of = o.heuristic + o.cost;
                    if(f < of)
                        return -1;
                    else if(f > of)
                        return 1;
                    else
                        return 0;
                }
            }
            
            /**
             * Gesorteerde lijst
             */
            class SortedList
            {
                private ArrayList list = new ArrayList();
                
                /**
                 * Geeft eerste element terug
                 * @return object
                 */
                public Object first()
                {
                    return list.get(0);
                }
                
                /**
                 * Leegt de lijst
                 */
                public void clear()
                {
                    list.clear();
                }
                
                /**
                 * Toevoegen van element
                 * @param o element
                 */
                public void add(Object o)
                {
                    list.add(o);
                    Collections.sort(list);
                }
                
                /**
                 * Verwijder element
                 * @param o element
                 */
                public void remove(Object o) 
                {
			list.remove(o);
		}
                
                /**
                 * Geeft de grote van de lijst
                 * @return grote
                 */
                public int size() 
                {
			return list.size();
		}
                
                /**
                 * Kijk of de lijst dit element bevat
                 * @param o element
                 * @return true als de lijst het element bevat, anders false
                 */
                public boolean contains(Object o) 
                {
			return list.contains(o);
		}
            }
        }
}


