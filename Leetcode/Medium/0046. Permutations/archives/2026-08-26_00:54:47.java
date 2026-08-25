class Solution {

    boolean[] visited;
    List<List<Integer>> answer = new ArrayList<>();;
    List<Integer> interim = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        
        dfs(0, nums);
        
        return answer;
    }

    void dfs(int depth, int[] nums) {
        if (depth == nums.length) {
            answer.add(new ArrayList<>(interim));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                interim.add(nums[i]);
                dfs(depth + 1, nums);
                interim.remove(interim.size() - 1);
                visited[i] = false;
            }
        }
    }
}