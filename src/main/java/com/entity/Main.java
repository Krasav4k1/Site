package com.entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
        public static void main(String[] args) {
            EntityManagerFactory factory = Persistence
                    .createEntityManagerFactory("primary");
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
//            Spting
//             singleton
            //DAO

//            List<Country> list = em.createQuery("select c from Country c join c.user u where u.firstName  = :name ").setParameter("name" , "Andrii").getResultList();
//            for(Country country : list){
//                System.out.println(country.getName());
//            }

/*            List<User> list = em.createQuery("select u from User u join u.country c where c.name  = :name ").setParameter("name" , "Ukraina").getResultList();
            for(User user : list){
                System.out.println(user.getFirstName());
            }*/

/*            List<User> list = em.createQuery("select s from User s").getResultList();
            for(User user : list){
                System.out.println(user.getFirstName());
            } */


//            List<Country> list = em.createQuery("select c from Country c where c.name = :name ").setParameter("name" , "Ukraina").getResultList();
//            for(Country country : list){
//                System.out.println(country.getName());
//            }

//            List<User> list = em.createQuery("select u from User u where u.firstName = :name ").setParameter("name" , "Andrii").getResultList();
//            for(User user : list){
//                System.out.println(user.getFirstName());
//            }


            Country country = new Country();
            country.setName("Ukraina");
            em.persist(country);

//            Oblast oblast = new Oblast();
//            oblast.setName("Ivano-Frankovsk");
//            oblast.setCountry(em.find(Country.class,1));
//            em.persist(oblast);
//            oblast = new Oblast();
//            oblast.setName("Zakarpatia");
//            oblast.setCountry(em.find(Country.class,1));
//            em.persist(oblast);
//            oblast = new Oblast();
//            oblast.setName("Rivne");
//            oblast.setCountry(em.find(Country.class,1));
//            em.persist(oblast);
//
//            Ragion ragion = new Ragion();
//            ragion.setName("Kosiv");
//            ragion.setOblast(em.find(Oblast.class,1));
//            em.persist(ragion);
//            ragion = new Ragion();
//            ragion.setName("Mukachevo");
//            ragion.setOblast(em.find(Oblast.class,2));
//            em.persist(ragion);
//            ragion = new Ragion();
//            ragion.setName("Kuznizovsk");
//            ragion.setOblast(em.find(Oblast.class,3));
//            em.persist(ragion);
//            ragion = new Ragion();
//            ragion.setName("Kalysh");
//            ragion.setOblast(em.find(Oblast.class,1));
//            em.persist(ragion);
//
//            City city = new City();
//            city.setName("Stari Kuty");
//            city.setRagion(em.find(Ragion.class,1));
//            em.persist(city);
//            city = new City();
//            city.setName("Mukachefo");
//            city.setRagion(em.find(Ragion.class,2));
//            em.persist(city);
//            city = new City();
//            city.setName("Kyznizovsk");
//            city.setRagion(em.find(Ragion.class,3));
//            em.persist(city);
//            city = new City();
//            city.setName("Kalysh");
//            city.setRagion(em.find(Ragion.class,4));
//            em.persist(city);


            User u = new User();
            u.setFirstName("Andrii");
            u.setLastName("Blyzniuk");
            u.setAge(18);
            u.setDay(22);
            u.setMouth(12);
            u.setYear(1997);
            u.setEmail("Andriubliznuk@mail.ru");
            u.setFoto("url###");
            u.setOnlineUser(1);
            u.setPassword("Andriu1997");
            u.setStatuFrendship(1);
            u.setCity(em.find(City.class,1));
            em.persist(u);

            AlbomFotoUser afu = new AlbomFotoUser();
            afu.setAlbomName("Summer");
            afu.setUser(em.find(User.class,1));
            em.persist(afu);

            Foto foto = new Foto();
            foto.setFoto("url###");
            foto.setAlbomFotoUser(em.find(AlbomFotoUser.class,1));
            em.persist(foto);

            Grup grup = new Grup();
            grup.setNameGrup("MDK");
            em.persist(grup);
            grup = new Grup();
            grup.setNameGrup("Orlionok");
            em.persist(grup);
            grup = new Grup();
            grup.setNameGrup("Type 11 class");
            em.persist(grup);


            u = new User();
            u.setFirstName("Kolia");
            u.setCity(em.find(City.class,2));
            u.setAge(18);
            u.setDay(1);
            u.setMouth(12);
            u.setYear(1997);
            u.setEmail("KoliaLukin@mail.ru");
            u.setPassword("qwerty");
            u.setLastName("Lukin");
            u.setFoto("url###");
            u.setStatuFrendship(1);
            u.setOnlineUser(1);
            em.persist(u);

            u = new User();
            u.setFirstName("Sasha");
            u.setLastName("Kozodoi");
            u.setAge(18);
            u.setDay(28);
            u.setMouth(02);
            u.setYear(1998);
            u.setEmail("SashaKozodoi@mail.ru");
            u.setFoto("url###");
            u.setOnlineUser(1);
            u.setPassword("123456");
            u.setStatuFrendship(1);
            u.setCity(em.find(City.class,3));
            em.persist(u);

            u = new User();
            u.setFirstName("Nazar");
            u.setLastName("Chyra");
            u.setAge(17);
            u.setDay(00);
            u.setMouth(00);
            u.setYear(1998);
            u.setEmail("ChytaNazar@mail.ru");
            u.setFoto("url###");
            u.setOnlineUser(1);
            u.setPassword("password");
            u.setStatuFrendship(1);
            u.setCity(em.find(City.class,4));
            em.persist(u);

/*            User u = em.find(User.class,3);
            c.setName("Rassia");
            u.setCountry(c);
            em.persist(c);
            em.persist(u);*/
//            AlbomMusic a = em.find(AlbomMusic.class,1);
//            User u = em.find(User.class,4);
//            a.setUsers(u);
//            em.persist(a);
           /* em.remove(em.find(User.class,1));*/
            em.getTransaction().commit();
            em.close();
            factory.close();

        }


    }

