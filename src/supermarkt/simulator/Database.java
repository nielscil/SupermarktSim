package supermarkt.simulator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Klasse die contact heeft met de Database 
 * @author Niels
 */
public class Database {

    private static final String dbName = "jdbc:mysql://eu-cdbr-azure-west-c.cloudapp.net:3306/supermarkt";
    
        /**
         * Haalt de magazijnvoorraad van producten uit de database 
         * en stopt ze in een lijst met producten
         * Deze producten hebben een naam, prijs, afdeling, en voorraad aantal
         * @return een lijst met producten uit de magazijnvoorraad
         */
	public static List<ProductWrapper> getProducten()
        {
            List<ProductWrapper> products = new ArrayList<>();
            Properties prop = new Properties();
            prop.put("zeroDateTimeBehavior","convertToNull");
            prop.put("user", "bba54e4fa78020");
            prop.put("password", "ca954bed");
            Connection conn = null;
            try
            {
                conn = DriverManager.getConnection(dbName, prop);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM product");
                while(rs.next())
                {
                    products.add(new ProductWrapper(new Product(rs.getNString("naam"),rs.getDouble("prijs"),rs.getInt("afdeling")),rs.getInt("magazijnVoorraad")));
                }
            } 
            catch (Exception e)
            {
            }
            finally
            {
                try
                {
                    conn.close();
                }catch(Exception e){};
            }
            return products;
	}

        /**
         * Haalt de winkelvoorraad van producten uit de database 
         * en stopt ze in een lijst met producten
         * Deze producten hebben een naam, prijs, afdeling, en voorraad aantal
         * @return een lijst met producten uit de winkelvoorraad
         */
	public static List<ProductWrapper> getWinkelproducten() 
        {
            List<ProductWrapper> products = new ArrayList<>();
            Properties prop = new Properties();
            prop.put("zeroDateTimeBehavior","convertToNull");
            prop.put("user", "bba54e4fa78020");
            prop.put("password", "ca954bed");
            Connection conn = null;
            try
            {
                conn = DriverManager.getConnection(dbName, prop);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM product");
                while(rs.next())
                {
                    products.add(new ProductWrapper(new Product(rs.getNString("naam"),rs.getDouble("prijs"),rs.getInt("afdeling")),rs.getInt("winkelVoorraad")));
                }
            } 
            catch (Exception e)
            {
            }
            finally
            {
                try
                {
                    conn.close();
                }catch(Exception e){};
            }
            return products;
	}

        /**
         * Laadt soorten klanten uit de database
         * @return een lijst van groepen
         * deze hebben een naam en een aantal producten die ze kopen
         */
        public static List<Groep> loadGroepen()
        {
            List<Groep> groepen = new ArrayList<>();
            Properties prop = new Properties();
            prop.put("zeroDateTimeBehavior","convertToNull");
            prop.put("user", "bba54e4fa78020");
            prop.put("password", "ca954bed");
            Connection conn = null;
            try
            {
                conn = DriverManager.getConnection(dbName, prop);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM groep");
                while(rs.next())
                {
                    Statement products = conn.createStatement();
                    String naam = rs.getNString("naam");
                    ResultSet rs1 = products.executeQuery("SELECT product.naam,product.prijs,product.afdeling FROM product INNER JOIN groep_product ON groep_product.naamProduct = product.naam WHERE groepNaam = \"" + naam + "\"");
                    List<Product> producten = new ArrayList<>();
                    while(rs1.next())
                    {
                        producten.add(new Product(rs1.getNString("naam"), rs1.getDouble("prijs"), rs1.getInt("afdeling")));
                    }
                    groepen.add(new Groep(naam, producten));
                }
            }
            catch (Exception e)
            {
                System.err.println(e.getMessage());
            }
            finally
            {
                try
                {
                    conn.close();
                }catch(Exception e){};
            }
            return groepen;
        }
        
        /**
         * Update de voorraad van producten (mutatie)
         * @param producten Lijst van producten die geüpdate worden in de databases
         */
	public static void setProducten(List<ProductWrapper> producten) 
        {
            Properties prop = new Properties();
            prop.put("zeroDateTimeBehavior","convertToNull");
            prop.put("user", "bba54e4fa78020");
            prop.put("password", "ca954bed");
            Connection conn = null;
            try
            {
                conn = DriverManager.getConnection(dbName, prop);
                Statement statement = conn.createStatement();
                for(ProductWrapper pw : producten)
                {
                    statement.executeUpdate("UPDATE product SET magazijnVoorraad = \"" + pw.getAantal()  + " WHERE naam = \""+ pw.getProductNaam() + "\";");
                    //statement.executeUpdate("INSERT INTO voorraadmutatie (aantal,dag,product) VALUES (" + pw.getAantal() + "," + Controller.DAG + ",\"" + pw.getProductNaam() + "\")");
                }
            } 
            catch (Exception e)
            {
            }
            finally
            {
                try
                {
                    conn.close();
                }catch(Exception e){};
            }
            
	}

        /**
         * Rekent gemiddeld uit hoeveel producten er van een product op 
         * de afdeling verkocht worden
         * Zodat er altijd genoeg is voor de klant
         * @param afdeling wordt gebruikt om te kijken of het om de 
         * kaas of vers afdeling gaat
         * @return het gemiddelde
         */
	public static int getGemiddelde(Afdeling afdeling) 
        {
            int afnr = 0;
            if(afdeling.getNaam().equals("Kaas"))
            {
               afnr = 1;
            }else
            {
               afnr = 2;
            }
            int aantal = 0;
            Properties prop = new Properties();
            prop.put("zeroDateTimeBehavior","convertToNull");
            prop.put("user", "bba54e4fa78020");
            prop.put("password", "ca954bed");
            Connection conn = null;
            try
            {
                conn = DriverManager.getConnection(dbName, prop);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("SELECT CEIL((COUNT(product.naam) / (SELECT max(dag) FROM voorraadMutatie))) AS Gemiddeld FROM product INNER JOIN voorraadMutatie On product.naam = voorraadMutatie.product WHERE product.afdeling = " + afnr + " AND aantal= \"-1\" GROUP BY product.naam ORDER BY Gemiddeld DESC");
                while(rs.next())
                {
                    aantal = rs.getInt("Gemiddeld");
                }
            } 
            catch (Exception e)
            {
                return -1;
            }
            finally
            {
                try
                {
                    conn.close();
                }catch(Exception e){};
            }
            if(aantal == 0)
                return 10;
            return aantal;
	}
        
        /**
         * Haalt uit de database de dag, dus dag 1, dag 2, etc.
         * Wordt gebruikt voor de methode Database.getGemiddelde
         * Dit wordt weergegeven als een int
         * @return de dag (als integer)
         */
        public static int getDay()
        {
            Properties prop = new Properties();
            prop.put("zeroDateTimeBehavior","convertToNull");
            prop.put("user", "bba54e4fa78020");
            prop.put("password", "ca954bed");
            Connection conn = null;
            try
            {
                conn = DriverManager.getConnection(dbName, prop);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("SELECT dag FROM voorraadmutatie ORDER BY dag DESC LIMIT 1");
                while(rs.next())
                {
                    return rs.getInt("dag") + 1;
                }
            } 
            catch (Exception e)
            {
                return 0;
            }
            finally
            {
                try
                {
                    conn.close();
                }catch(Exception e){};
            }
            return 0;
        }

        /**
         * Verlaagt de voorraad van producten
         * @param product wordt in een lijst van producten gestopt
         */
	public static void lowerWinkelproduct(Product product) 
        {
            List<ProductWrapper> products = new ArrayList<>();
            Properties prop = new Properties();
            prop.put("zeroDateTimeBehavior","convertToNull");
            prop.put("user", "bba54e4fa78020");
            prop.put("password", "ca954bed");
            Connection conn = null;
            try
            {
                conn = DriverManager.getConnection(dbName, prop);
                Statement statement = conn.createStatement();
                //statement.executeUpdate("UPDATE product SET winkelVoorraad = (SELECT * FROM (SELECT winkelVoorraad - 1 FROM product WHERE naam = \"" + product.getNaam() + "\")tblTmp) WHERE naam = \""+ product.getNaam()+ "\";");
                statement.executeUpdate("INSERT INTO voorraadmutatie (aantal,dag,product) VALUES (-1," + Controller.DAG + ",\"" + product.getNaam() + "\")");
            }
            catch (Exception e)
            {
                String test = e.getMessage();
            }
            finally
            {
                try
                {
                    conn.close();
                }catch(Exception e){};
            }
	}

        /**
         * Zet de winkelproducten in de database
         * @param producten de producten
         */
	public static void setWinkelproduct(List<ProductWrapper> producten) 
        {
            Properties prop = new Properties();
            prop.put("zeroDateTimeBehavior","convertToNull");
            prop.put("user", "bba54e4fa78020");
            prop.put("password", "ca954bed");
            Connection conn = null;
            try
            {
                conn = DriverManager.getConnection(dbName, prop);
                Statement statement = conn.createStatement();
                for(ProductWrapper pw : producten)
                {
                    statement.executeUpdate("UPDATE product SET winkelVoorraad = \"" + pw.getAantal()  + " WHERE naam = \""+ pw.getProductNaam() + "\";");
                    //statement.executeUpdate("INSERT INTO voorraadmutatie (aantal,dag,product) VALUES (" + pw.getAantal() + "," + Controller.DAG + ",\"" + pw.getProductNaam() + "\")");
                }
                //statement.executeUpdate("UPDATE product SET winkelVoorraad = (SELECT * FROM (SELECT winkelVoorraad + 1 FROM product WHERE naam = \"" + product + "\")tblTmp) WHERE naam = \""+ product + "\"");
            } 
            catch (Exception e)
            {
            }
            finally
            {
                try
                {
                    conn.close();
                }catch(Exception e){};
            }
	}
        
        /**
         * Haalt de omzet op
         * @return de omzet
         */
	public static double getOmzet() 
        {
            Properties prop = new Properties();
            prop.put("zeroDateTimeBehavior","convertToNull");
            prop.put("user", "bba54e4fa78020");
            prop.put("password", "ca954bed");
            Connection conn = null;
            try
            {
                conn = DriverManager.getConnection(dbName, prop);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("SELECT IFNULL(SUM(product.prijs),0.0) AS Omzet FROM product INNER JOIN voorraadmutatie ON product.naam = voorraadmutatie.product GROUP BY product.naam");
                while(rs.next())
                {
                    return rs.getInt("Omzet");
                }
            } 
            catch (Exception e)
            {
                return 0.0;
            }
            finally
            {
                try
                {
                    conn.close();
                }catch(Exception e){};
            }
            return 0.0;
	}

        /**
         * Haalt de product types op
         * @return lijst met producten
         */
	public static List<Product> getProductTypes() {
            List<Product> products = new ArrayList<>();
            Properties prop = new Properties();
            prop.put("zeroDateTimeBehavior","convertToNull");
            prop.put("user", "bba54e4fa78020");
            prop.put("password", "ca954bed");
            Connection conn = null;
            try
            {
                conn = DriverManager.getConnection(dbName, prop);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM product");
                while(rs.next())
                {
                    products.add(new Product(rs.getNString("naam"),rs.getDouble("prijs"),rs.getInt("afdeling")));
                }
            } 
            catch (Exception e)
            {
            }
            finally
            {
                try
                {
                    conn.close();
                }catch(Exception e){};
            }
            return products;
	}
        
        /**
         * Checkt of product nog op voorraad is
         * @param product product
         * @return true als op voorraad , false anders
         */
        public static boolean checkProduct(String product)
        {
            Properties prop = new Properties();
            prop.put("zeroDateTimeBehavior","convertToNull");
            prop.put("user", "bba54e4fa78020");
            prop.put("password", "ca954bed");
            Connection conn = null;
            try
            {
                conn = DriverManager.getConnection(dbName, prop);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("SELECT magazijnVoorraad FROM product WHERE = \"" + product + "\"" );
                while(rs.next())
                {
                    return rs.getInt("magazijnVoorraad") > 0;
                }
            } 
            catch (Exception e)
            {
                return false;
            }
            finally
            {
                try
                {
                    conn.close();
                }catch(Exception e){};
            }
            return false;
        }

        /**
         * verlaagt magazijnproducten
         * @param product product
         */
	private static void lowerProducten(String product) 
        {
            Properties prop = new Properties();
            prop.put("zeroDateTimeBehavior","convertToNull");
            prop.put("user", "bba54e4fa78020");
            prop.put("password", "ca954bed");
            Connection conn = null;
            try
            {
                conn = DriverManager.getConnection(dbName, prop);
                Statement statement = conn.createStatement();
                statement.executeUpdate("UPDATE product SET magazijnVoorraad = (SELECT * FROM (SELECT magazijnVoorraad - 1 FROM product WHERE naam = \"" + product + "\")tblTmp) WHERE naam = \""+ product + "\"");
            } 
            catch (Exception e)
            {
            }
            finally
            {
                try
                {
                    conn.close();
                }catch(Exception e){};
            }
	}
        
}
