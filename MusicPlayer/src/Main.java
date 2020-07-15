import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Store store = new Store();
        Playlist player = new Playlist("MyList");
        boolean flag;

        menu();
        System.out.print("Enter Choice: ");
        int choice = input.nextInt();

        while (choice!=0){
            switch (choice){
                case 1:
                    menu();
                    break;
                case 2:
                    flag = player.showPlayList();
                    if(!flag)
                        System.out.println("Playlist Empty.\n");
                    break;
                case 3:
                    player.goToStart();
                    flag = player.play();
                    if(!flag)
                        System.out.println("Playlist Empty!\n");
                    break;
                case 4:
                    flag = player.next();
                    if(!flag)
                        System.out.println("End of Playlist!\n");
                    break;
                case 5:
                    flag = player.previous();
                    if(!flag)
                        System.out.println("Start of Playlist!\n");
                    break;
                case 6:
                    store.showTracks();
                    break;
                case 7:
                    store.showTracks();
                    System.out.print("Enter Track to Add: ");
                    Track track;
                    if(input.hasNextInt()) {
                        int index = input.nextInt();
                        track = store.getTrack(index-1);
                    }
                    else{
                        input.nextLine();
                        String title = input.nextLine();
                        track = store.getTrack(title);
                    }
                    System.out.print("Enter 1 to append, 0 to Specify position: ");
                    int append = input.nextInt();
                    if(append == 0){
                        player.showPlayList();
                        System.out.print("Enter position: ");
                        int position = input.nextInt();
                        flag = player.addTrack(track,position-1);
                    }
                    else
                        flag = player.addTrack(track);
                    if(!flag)
                        System.out.println("Track Addition Failed, Try Again.\n");
                    else
                        System.out.println("Track Addition Successful.\n");
                    break;
                case 8:
                    if(player.showPlayList()) {
                        System.out.print("Enter Track to remove: ");
                        if (input.hasNextInt()) {
                            int index = input.nextInt();
                            flag = player.removeTrack(index-1);
                        }
                        else {
                            input.nextLine();
                            String title = input.nextLine();
                            flag = player.removeTrack(title);
                        }
                        if (!flag)
                            System.out.println("Track Removal Failed, Try Again.\n");
                        else
                            System.out.println("Track Removal Successful.\n");
                    }
                    else
                        System.out.println("Playlist Empty.\n");
                    break;
                case 9:
                    player.delete();
                    System.out.println("Playlist Erased.\n");
                    break;
                case 10:
                    input.nextLine();
                    System.out.print("Enter Name: ");
                    String name = input.nextLine();
                    player.setName(name);
                    System.out.println("Playlist Renamed to: "+name+"\n");
                    break;
                default:
                    System.out.println("Enter Valid Option!\n");
            }
            System.out.print("Enter Choice: ");
            choice = input.nextInt();

        }
        System.out.println("Closed.\n");
    }

    public static void menu(){
        System.out.println("\n------------------------HOME------------------------");
        System.out.println("\t01. Index");
        System.out.println("\t02. View Play List");
        System.out.println("\t03. Start Play List");
        System.out.println("\t04. Play Next (>>)");
        System.out.println("\t05. Play Previous (<<)");
        System.out.println("\t06. View Store");
        System.out.println("\t07. Add Track");
        System.out.println("\t08. Remove Track");
        System.out.println("\t09. Delete PlayList");
        System.out.println("\t10. Set PlayList Name");
        System.out.println("\t00. Exit");
        System.out.println("----------------------------------------------------\n");
    }
}
