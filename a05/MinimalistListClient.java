public class MinimalistListClient {

    public int getMinimum(MinimalistList<Integer> list) {
        // TODO implement this method correctly
        return 0;
    }

    public int getSize(MinimalistList<Integer> list) {
        // TODO implement this method correctly
        return 0;
    }

    public static void main(String[] args) {
        MinimalistList<Integer> intList = new MinimalistList<>();
        intList.addFirst(42);
        intList.addFirst(21);
        intList.addFirst(81);

        MinimalistListClient client = new MinimalistListClient();

        System.out.println(client.getMinimum(intList));
        System.out.println(client.getSize(intList));

    }
}
