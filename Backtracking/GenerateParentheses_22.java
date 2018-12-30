class GenerateParentheses_22{
	public List<String> generateParenthesis(int n) {
        List<String> lst = new ArrayList<String>();
        if(n < 0){
            lst.add("");
            return lst;
        }
        generate(n, n, lst, "");
        return lst;
    }
    
    public void generate(int left, int right, List<String> lst, String parent){
        if(left < 0 || right < 0) return ;
        if(left == 0 && right == 0){
            lst.add(parent);
            return;
        }
        generate(left - 1, right, lst, new String(parent+"("));
        if(left < right){
            generate(left, right - 1, lst, new String(parent+")"));
        }
    }
}