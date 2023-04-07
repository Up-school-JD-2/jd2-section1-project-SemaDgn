import entity.*;
import service.MovieManager;
import service.UserManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //İnitilazing
        printMenu();
        UserManager.generateUser();
        MovieManager.generateMovie();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.print("Seçiminiz: ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("--------------------------------");
                        System.out.print("Kullanıcı Adı :");
                        String userName = sc.next();
                        System.out.print("Şifre :");
                        String password = sc.next();
                        User user = UserManager.logInSession(userName, password);
                        if (user != null && DomainConstants.activeUser != null)
                            System.out.println("*** HoşGeldiniz: " + DomainConstants.activeUser.getUserName() + " ***\n");
                        else
                            System.out.println("*** Girdiğiniz kullanıcı bulunamadı. ***\n");
                        System.out.println("--------------------------------");
                    }
                    case 2 -> {
                        System.out.println("--------------------------------");
                        UserManager.logOutSession();
                        System.out.println("*** Çıkış işleminiz yapıldı. ***");
                        System.out.println("--------------------------------");
                    }

                    case 3 -> {
                        System.out.println("--------------------------------");

                        System.out.print("Film No: ");
                        long no = Long.parseLong(sc.next().trim());
                        System.out.print("Film Başlığı: ");
                        String movieCaption = sc.next();
                        System.out.print("Yönetmen: ");
                        Director director = new Director(sc.next());
                        System.out.println("Lütfen oyuncuları giriniz: ");

                        List<Cast> casts = new ArrayList<>();
                        System.out.print("1. Oyuncu: ");
                        Cast cast = new Cast(sc.next());
                        casts.add(cast);
                        System.out.print("2. Oyuncu: ");
                        cast = new Cast(sc.next());
                        casts.add(cast);

                        System.out.print("Tarih: ");
                        String releaseDate = sc.next();

                        System.out.print("Açıklama: ");
                        String explanation = sc.next();

                        System.out.print("Film Türü (1-Aksiyon/ 2-Komedi / 3-Korku / 4-Bilim Kurgu / 5-Aşk / 6-Drama) ");

                        var moviType = MovieType.ACTION;
                        if(sc.hasNextInt()) {
                            int type = Integer.parseInt(sc.next());
                            switch (type) {
                                case 1 -> {
                                    moviType = MovieType.ACTION;
                                }
                                case 2 -> {
                                    moviType = MovieType.COMEDY;
                                }
                                case 3 -> {
                                    moviType = MovieType.HORROR;
                                }
                                case 4 -> {
                                    moviType = MovieType.SCIENCEFICTON;
                                }
                                case 5 -> {
                                    moviType = MovieType.LOVE;
                                }
                                case 6 -> {
                                    moviType = MovieType.DRAMEDY;
                                }
                                default -> moviType = null;
                            }


                            Movie movie = new Movie(no, movieCaption, director, casts, releaseDate, explanation, moviType);
                            Boolean outcome = MovieManager.addMovie(movie);
                            if (outcome)
                                System.out.println("***Film eklendi. ***");
                            else
                                System.out.println("***Film eklenirken bir sorun oluştu.Tekrar deneyin. ***");
                        }
                        else {
                            System.out.println("*** Geçersiz bir film türü seçtiniz. ***");
                            sc=new Scanner(System.in);
                        }
                        System.out.println("--------------------------------");
                    }
                    case 4 -> {
                        System.out.println("--------------------------------");
                        printMovieList();
                        System.out.print("Silinecek Film No: ");
                        long no = sc.nextLong();
                        Boolean outcome = MovieManager.deleteMovie(no);
                        if (outcome)
                            System.out.println("*** Film silindi. ***");
                        else
                            System.out.println("*** Film silinirken bir sorun oluştu.Tekrar deneyin. ***");

                        System.out.println("--------------------------------");
                    }
                    case 5 -> {
                        System.out.println("--------------------------------");
                        System.out.print("Film adını giriniz: ");
                        sc.nextLine();
                        String movieName = sc.nextLine();
                        Movie movie = MovieManager.searchMovieByName(movieName);
                        if (movie == null) {
                            System.out.println("*** Film bulunamadı. ***");
                            break;
                        }
                        System.out.println("--------------------------------");
                        System.out.println("Film: " + movie.getMovieCaption());
                        System.out.println("Yönetmen: " + movie.getDirector().getName());
                        System.out.println("Tarih: " + movie.getReleaseDate());
                        System.out.println("Açıklama: " + movie.getExplanaton());
                        System.out.println("--------------------------------");
                    }
                    case 6 -> {
                        System.out.println("--------------------------------");
                        System.out.print("Kullanıcı adını giriniz: ");
                        sc.nextLine(); //
                        String UserName = sc.nextLine();
                        System.out.print("Şifreniz: ");
                        String password = sc.nextLine();
                        System.out.print("e-Mail Adresiniz: ");
                        String email = sc.nextLine();
                        User user = new User(UserName, password, email);
                        boolean result = UserManager.addUser(user);
                        if (result) {
                            System.out.println("*** Kullanıcı başarıyla ekledi. ***");
                            break;
                        }
                        System.out.println("--------------------------------");
                    }
                    case 7 -> {
                        System.out.println("--------------------------------");
                        System.out.print("Aranacak kullanıcının adını giriniz: ");
                        String userName = sc.next();
                        User user = UserManager.searchUserByName(userName);
                        if (user == null) {
                            System.out.println("Kullanıcı bulunamadı.");
                            break;
                        } else {
                            System.out.println("Kullanıcı Adı: " + user.getUserName());
                            System.out.println("e-Mail: " + user.getEmail());
                        }

                        System.out.println("--------------------------------");
                    }
                    case 8 -> {
                        System.out.println("--------------------------------");
                        System.out.println("Silinecek kullanıcı adını giriniz: ");
                        sc.nextLine();
                        String userName = sc.nextLine();
                        System.out.print("Şifreniz: ");
                        String password = sc.nextLine();

                        User user = UserManager.searchUserByName(userName);
                        if (user != null && user.getPassword().equalsIgnoreCase(password)) {
                            UserManager.deleteUser(user);
                            System.out.println("*** Kullanıcı başarıyla silindi. ***");
                            break;
                        } else {
                            System.out.println("*** Girdiğiniz bilgilere ait kullanıcı bulunamadı. ***");
                        }
                        System.out.println("--------------------------------");
                    }
                    case 10 -> {
                        for (User user : UserManager.usersList
                        ) {
                            System.out.println("kullanıcı adı:" + user.getUserName());
                            System.out.println("şifre:" + user.getPassword());
                            System.out.println("email:" + user.getEmail());
                        }

                    }
                    case 9 -> {
                        printMovieList();
                    }
                    case -1 -> {
                        System.out.println("İyi günler");
                    }
                    default -> printMenu();
                }
            } else {
                System.out.println("Lütfen seçiminizi menü üzerinden beliritlen sayılarla ifade ediniz.");
                sc = new Scanner(System.in);

            }
        } while (choice != -1);

    }

    public static void printMenu() {
        System.out.println("##### MOVIE LİBRARY #####");
        System.out.println("1: Kullanıcı Giriş");
        System.out.println("2: Kullanıcı Çıkış");
        System.out.println("3: Film Ekle");
        System.out.println("4: Film Sil");
        System.out.println("5: Film Ara");
        System.out.println("6: Kullanıcı Ekleme");
        System.out.println("7: Kullanıcı Arama");
        System.out.println("8: Kullanıcı Silme");
        System.out.println("9: Film Listele");
        System.out.println("-1: Çıkış \n\n");
    }

    public static void printMovieList() {
        for (Movie movie : MovieManager.moviesList
        ) {
            System.out.println("Film No: " + movie.getId());
            System.out.println("Film: " + movie.getMovieCaption());
            System.out.println("Yönetmen: " + movie.getDirector().getName());
            System.out.println("Tür: " + movie.getMovieType().getExplanation());
            System.out.println("--------------------------------");
        }
    }

}
