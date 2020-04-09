package kz.sabyrzhan.algo.leetcode.p30;

import java.util.*;

public class SubstringWithConcatOfAllWords {
    public static void main(String[] args) {
        SubstringWithConcatOfAllWords m = new SubstringWithConcatOfAllWords();
        m.execute();
    }

    private void execute() {
        /*String str = "foobarpjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnx" +
                "xdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnm" +
                "fvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqj" +
                "nfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxida" +
                "iqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabeji" +
                "fmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsx" +
                "acfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjl" +
                "kpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvu" +
                "hcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclex" +
                "xisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwn" +
                "dvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkf" +
                "bbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqm" +
                "drczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarkn" +
                "nhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhont" +
                "wmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbieg" +
                "smweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxelfoobar";
        String[] words = {"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};*/

        String str = "barfoothefoobarman";
        String[] words = {"foo","bar"};

        Solution s = new Solution();
        List<Integer> result = s.findSubstring(str, words);
        System.out.println(result);
    }

    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> result = new ArrayList<>();
            Map<String, Integer> wMap = new HashMap<>();
            for(String word : words) {
                wMap.put(word, wMap.getOrDefault(word,0) + 1);
            }

            int wordLen = words[0].length();
            int count = words.length;
            for(int i = 0; i < s.length() - count * wordLen + 1; i++) {
                Map<String, Integer> seen = new HashMap<>();
                int j = 0;
                while(j < count) {
                    String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                    if (wMap.containsKey(word)) {
                        seen.put(word, seen.getOrDefault(word, 0) + 1);
                        if (seen.get(word) > wMap.get(word)) {
                            break;
                        }
                    } else {
                        break;
                    }

                    j++;
                }

                if (j >= count) {
                    result.add(i);
                }
            }

            return result;
        }
    }
}
