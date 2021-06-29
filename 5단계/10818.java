public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<String> list = Arrays.asList(br.readLine().split(" "));
        Stream<Integer> tmp = list.stream().map(x -> Integer.parseInt(x));
        List<Integer> li = tmp.collect(Collectors.toList());
        li.sort(Comparator.naturalOrder());
        bw.write(Integer.toString(li.get(0))+' ');
        bw.write(Integer.toString(li.get(N-1)));
        bw.flush();bw.close();br.close();
    }
}
