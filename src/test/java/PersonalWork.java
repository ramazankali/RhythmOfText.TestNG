import stringmanipulations.Consol;

public class PersonalWork {
    public static void main(String[] args) {
        String text="Google Ads is an online advertising platform developed by Google, where advertisers bid to display brief advertisements, service offerings, product listings, or videos to web users. It can place ads both in the results of search engines like Google Search and on non-search websites, mobile apps, and videos.";
        Consol.Text.findTheLongestWordsInAText(text).
                keySet().
                stream().
                forEach(key->Consol.Text.findTheLongestWordsInAText(text).
                        get(key).
                        stream().
                        map(word->word+",").
                        forEach(System.out::print));


    }
}
