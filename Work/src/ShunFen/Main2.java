package ShunFen;

public class Main2 {
//    public static int MtoN (String str, int m, int n){
//        int hashNum[256];   //通过字符找到数字
//        for (int i = 0; i <= 9; i++)
//            hashNum['0' + i] = i;
//        for (int i = 10; i <= 35; i++)
//            hashNum['A' + i] = i;
//
//        int hashChar[256]; //通过数字找到字符
//        for (int i = 0; i <= 9; i++)
//            hashChar[i] = '0' + i;
//        for (int i = 10; i <= 35; i++)
//            hashChar[i] = 'A' + i;
//
//        int realValue = 0;    //十进制数
//        int maxCh = hashChar[m];      //m进制每位能表示的最大值对应的字符
//        for (int i = 0; i < str.length(); i++)    //输入字符串str转换为十进制
//        {
//            if (str[i] >= maxCh)
//                return 60;
//            realValue = realValue*m + hashNum[str[i]];
//        }
//        return realValue;
//    }
}


//        int MtoN(string &str, int m, int n)
//        {
//        int hashNum[256];   //通过字符找到数字
//        for (int i = 0; i <= 9; i++)
//        hashNum['0' + i] = i;
//        for (int i = 10; i <= 35; i++)
//        hashNum['A' + i] = i;
//
//        int hashChar[256]; //通过数字找到字符
//        for (int i = 0; i <= 9; i++)
//        hashChar[i] = '0' + i;
//        for (int i = 10; i <= 35; i++)
//        hashChar[i] = 'A' + i;
//
//        int realValue = 0;    //十进制数
//        int maxCh = hashChar[m];      //m进制每位能表示的最大值对应的字符
//        for (int i = 0; i < str.length(); i++)    //输入字符串str转换为十进制
//        {
//        if (str[i] >= maxCh)
//        return 60;
//        realValue = realValue*m + hashNum[str[i]];
//        }
//        return realValue;
//        }
//        int main()
//        {
//        string str;
//        string s1="";
//        string s2="";
//        int flag = 1;
//        vector<int> v;
//        cin >> str;
//        for (int i = 0; i < str.size(); i++) {
//        if (str[i] == ':') {
//        flag = 0;
//        continue;
//        }
//        if (flag) {
//        s1 += str[i];
//        }
//        if (!flag) {
//        s2 += str[i];
//        }
//        }
//        for (int i = 1; i <= 16; i++) {
//        int a, b;
//        a = MtoN(s1, i, 10);
//        b = MtoN(s2, i, 10);
//        if (a < 24 && a >= 0 && b < 60 && b >= 0) {
//        v.push_back(i);
//        }
//        }
//        for (int i = 0; i <v.size(); i++) {
//        cout << v[i]<<'\0';
//        }
//        system("pause");
//        }