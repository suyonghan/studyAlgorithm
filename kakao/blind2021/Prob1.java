package kakao_blind_2021;

public class Prob1 {
    public static void main(String[] args) {
        Prob1 p = new Prob1();
        System.out.println(p.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(p.solution("z-+.^."));
        System.out.println(p.solution("=.="));
        System.out.println(p.solution("123_.def"));
        System.out.println(p.solution("abcdefghijklmn."));
    }
    public String solution(String new_id) {
        String answer = "";

        answer = new_id.toLowerCase();
        //step1 대문자->소문자

        String temp = "";
        for (int i = 0; i < answer.length(); i++) {
            if ((answer.charAt(i) >= 48 && answer.charAt(i) <= 57) || (answer.charAt(i) >= 'a' && answer.charAt(i) <= 'z') || answer.charAt(i) == '-' || answer.charAt(i) == '_' || answer.charAt(i) == '.')
                temp += answer.charAt(i);
            else
                continue;
        }
        answer = temp;
        //step2 소문자, 숫자, 빼기, 마침표를 제외한 문자는 제거

        for(int i = 0; i < answer.length(); i++){
            if (answer.charAt(i) == '.') {
                if(i+1 < answer.length() && answer.charAt(i+1) == '.'){
                    //System.out.println("xx  " + answer.substring(0, i));
                    answer = answer.substring(0, i) + answer.substring(i+1);
                    i--;
                }
            }
        }
        //step3 마침표가 연속이면 1개로 치환하기
        //System.out.println(answer);
        if (answer.length() > 0 && answer.charAt(0) == '.') {
            answer = answer.substring(1, answer.length());
        }
        //System.out.println(answer);
        if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }
        //step4 처음 또는 마지막문자가 마침표면 제거
        //System.out.println(answer);
        if (answer.length() == 0)
            answer = "a";
        //step5 빈문자열이면 a 추가

        if (answer.length() > 15) {
            if (answer.charAt(14) == '.')
                answer = answer.substring(0, 14);
            else
                answer = answer.substring(0, 15);
        }
        //step6 문자열이 16이상이면 15개남기고 제거, 제거이후 .이 마지막 문자에 존재하면 제거

        if (answer.length() < 3) {
            if(answer.length() == 1)
                answer = answer + answer + answer;
            else
                answer = "" + answer.charAt(0) + answer.charAt(1) + answer.charAt(1);
        }
        //step7 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        return answer;
    }

    public int findDotEnd(String new_id, int startIndex) {
        int endIndex = startIndex;
        for (int i = startIndex; i < new_id.length(); i++) {
            if ('.' == new_id.charAt(i))
                endIndex++;
            else
                break;
        }
        return endIndex;
    }
}
