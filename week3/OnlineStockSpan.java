class StockSpanner {
  List<Integer> prices;
  List<Integer> spans;

  public StockSpanner() {
    prices = new ArrayList<>();
    spans = new ArrayList<>();

    prices.add(Integer.MAX_VALUE);
    spans.add(0);
  }

  public int next(int price) {
    int prevPrice = prices.get(prices.size()-1);
    int span = 1;
    if (price >= prevPrice) {
      int i = prices.size() - 1;

      do {
        span += 1;
        i--;
      } while (i >= 0 && price >= prices.get(i));

      prices.add(price);
      spans.add(span);
      return span;
    } else {
      span = 1;
      prices.add(price);
      spans.add(span);
      return span;
    }
  }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
