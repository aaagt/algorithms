public class Main {

    public static void main(String[] args) {
        int[] prices = {13, 17, 19, 25, 25, 25, 25, 25, 25, 27, 30};

        System.out.println("Для 31: " + countMore(prices, 31)); // 0
        System.out.println("Для 26: " + countMore(prices, 26)); // 2
        System.out.println("Для 25: " + countMore(prices, 25)); // 2
        System.out.println("Для 20: " + countMore(prices, 20)); // 8
    }

    public static int countMore(int[] prices, int money) {
        if (prices[0] > money) {
            return prices.length; // все недоступны
        }

        if (prices[prices.length - 1] < money) {
            return 0; // все доступны
        }

        int left = 0;
        int right = prices.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;

            if (prices[middle] > money) {
                if (prices[middle - 1] <= money) {
                    return prices.length - middle;
                } else {
                    right = middle - 1;
                }
            } else {
                left = middle + 1;
            }
        }

        return 0; // иначе не скомпилится, джава сама не знает бинпоиск
    }
}