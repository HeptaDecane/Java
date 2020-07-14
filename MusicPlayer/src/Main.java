public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        store.showStore();
        System.out.println();
        Playlist favs = new Playlist("favs");
        favs.addTrack(store.getTrack(0));
        favs.addTrack(store.getTrack(2));
        favs.addTrack(store.getTrack(27));
        favs.showPlayList();
        System.out.println();

        favs.next();
        favs.next();

        favs.next();
        favs.next();
        favs.next();
        favs.next();

        favs.previous();
        favs.previous();
        favs.previous();
        favs.previous();
        favs.previous();



    }
}
