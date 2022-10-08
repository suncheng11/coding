package leetCode293;

class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
      List<String> ret = new ArrayList<>();
      char[] chars = currentState.toCharArray();
      for (int i = 0; i < chars.length-1; i++) {
          if (chars[i] == chars[i+1]&& chars[i+1] == '+') {
              chars[i] ='-';
              chars[i+1] ='-';
              ret.add(new String(chars));
              chars[i] ='+';
              chars[i+1] ='+';
          }
      }

      return ret;
  }
}