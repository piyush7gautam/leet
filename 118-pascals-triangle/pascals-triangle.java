class Solution {
    public List<List<Integer>> generate(int n) {
         List<List<Integer>> r = new ArrayList<>();
        if (n == 0) {
            return r;
        }

        if (n== 1) {
            List<Integer> f = new ArrayList<>();
            f.add(1);
            r.add(f);
            return r;
        }

        r = generate(n - 1);
        List<Integer> p = r.get(n - 2);
        List<Integer> c = new ArrayList<>();
        c.add(1);

        for (int i = 1; i < n - 1; i++) {
            c.add(p.get(i - 1) + p.get(i));
        }

        c.add(1);
        r.add(c);

        return r;
    }
}