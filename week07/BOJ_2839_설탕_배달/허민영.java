import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //2839 - 설탕 배달
    static int[] dp = new int[5001]; //값을 저장해둘 배열 선언
    static int am; //5의 배수일 때 필요한 봉지 수
    static int em; //3의 배수일 때 필요한 봉지 수
    static int ans; //출력 변수
    static int max = Integer.MAX_VALUE; //더 적은 봉지의 개수를 찾기 위한 최대 값 변수 선언
    static boolean check = false; //3의 배수도 아니고 5의 배수도 아니고 15의 배수도 아닌데, 3킬로와 5킬로 봉지로 17을 딱 만들 수 있는 경우에 check를 true로

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n % 5 == 0) { //n이 5의 배수일 때 10
            am = n / 5;
            dp[n] = am; //dp배열에 해당 수를 저장한다.

            if (n % 3 == 0) {  //만약에 5의 배수이면서 3의 배수라면? // ex) 45
                dp[n] = am;
                //사실 5의 배수이면서 3의 배수이면 dp에 저장되어야할 값은 어차피 5킬로그램 am개 가 답이 될 수밖에 없다.
            }
        } else if (n % 3 == 0) { //5의 배수는 아니지만 3의 배수일 때 ->ex) 9
            em = n / 3;
            dp[n] = em; //dp배열에 해당 수를 저장한다.

        }


        //3의 배수도 아니고 5의 배수도 아닐 때를 확인하기 위한 반복문  -> ex) 17, 11 일 때
        for (int i = 1; i < n; i++) {
            //일단 5의 배수를 n이 0보다 작아질 때까지 빼고 3으로 나눠지는지 확인해준다.
            //i가 1일때는 n에서 5를 뺴주고
            //한번의 for문이 끝나서 i가 2가 되었을 때는 5*2해서 10을 n에서 빼준다.

            if (((n - (i * 5)) < 0)) { //만약에 5의 배수를 n에서 빼줬는데 0보다 작을 때
                //check가 false이고, dp에 값이 넣어진 적이 없으면 정확하게 N킬로그램을 만들 수 없다는 의미이므로 -1을 출력한다.
                if (!check && dp[n] == 0) {
                    System.out.println(-1);
                } else { //그 외의 경우는 dp가 0이 아닐 때
                    if (dp[n] != 0) {
                        System.out.println(dp[n]);
                    }
                }
                return; //(n - (i * 5)) < 0 이기 때문에 더이상 for문을 진행시키면 안되기 때문에 return
            }

            if ((n - (i * 5)) % 3 == 0) {  //n에서 5의 배수를 뺀 다음에 3으로 나눠 떨어진다면
                int ss = (n - (i * 5)) / 3; //3으로 나눈 결과를 ss변수에 담고
                if (ss + i < max) { //max변수보다 ss에서 i(5킬로그램 봉지 수)를 더한 값이 작으면
                    ans = ss + i;   // dp에 값이 안넣어져있다면 ans를 대입하고
                    if (ans > 0) {   //이미 dp에 값이 있다면 dp와 ans의 값을 비교하여 dp보다 ans가 더 작다면 dp에 ans의 값을 넣어준다.
                        if (dp[n] == 0) {
                            dp[n] = ans;
                        } else if (dp[n] > 0) {
                            if (dp[n] > ans) {
                                dp[n] = ans;
                            }
                        }
                    }

                    check = true; // 예를 들어 17을 보면 17-5 = 12 -> 12 / 3 = 4로 나누어떨어짐
                    //이렇게 3의 배수도 아니고 5의 배수도 아니고 15의 배수도 아닌데, 3킬로와 5킬로 봉지로 17을 딱 만들 수 있는 경우에 check를 true로 바꿔준다.
                }
            }
        }

    }

}