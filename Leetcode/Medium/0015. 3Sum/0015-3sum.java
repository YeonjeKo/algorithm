class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            while (start < end) {
                if (nums[i] + nums[start] + nums[end] == 0) {
                    answer.add(Arrays.asList(nums[i], nums[start], nums[end]));

                    // // 중복된 start 값 건너뛰기
                    while (start < end && nums[start] == nums[start + 1])
                        start++;
                    // // 중복된 end 값 건너뛰기
                    while (start < end && nums[end] == nums[end - 1])
                        end--;

                    start++;
                    end--;
                } else if (nums[i] + nums[start] + nums[end] < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return answer;
    }
}