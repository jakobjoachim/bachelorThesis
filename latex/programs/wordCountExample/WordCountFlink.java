public class SocketTextStreamWordCount {
// configuration lines removed for clearity
public static void main(String[] args) throws Exception {
  // configuration lines removed for clearity
  DataStream<String> text = env
    .addSource(new FlinkKafkaConsumer011<>("test",
    new SimpleStringSchema(), properties));
  DataStream<Tuple2<String, Integer>> counts = text
    .flatMap(new LineSplitter()).keyBy(0).sum(1);
  counts.print();
  env.execute("Java WordCount from SocketTextStream Example");
  }

  public static final class LineSplitter
    implements FlatMapFunction<String, Tuple2<String, Integer>> {
    @Override
    public void flatMap(String value,
      Collector<Tuple2<String, Integer>> out) throws Exception {
      // normalize and split the line
      String[] tokens = value.toLowerCase().split("\\W+");
        // emit the pairs
      for (String token : tokens) {
        if (token.equals("test")) {
          throw new Exception();
        }
        if (token.length() > 0) {
          out.collect(new Tuple2<String, Integer>(token, 1));
        }
      }
    }
  }
}
