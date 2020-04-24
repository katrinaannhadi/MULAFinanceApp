package org.mula.finance.Models;

import android.os.Parcel;
import org.mula.finance.R;

import java.util.ArrayList;

//class for objects to classify restaurants
public class Article {

    //unique ID for Article object
    private int articleID;
    //name, type of cuisine, location, rating
    private String articleTitle;
    private String articleCategory;
    private String articleSnippet;
    private String articleFull;
    private String imageURL;


    public Article() {
    }

    public Article(int articleID, String articleTitle, String articleCategory, String articleSnippet, String articleFull, String imageURL) {
        this.articleID = articleID;
        this.articleTitle = articleTitle;
        this.articleCategory = articleCategory;
        this.articleSnippet = articleSnippet;
        this.articleFull = articleFull;
        this.imageURL = imageURL;
    }

    public Article(Parcel source) {
        articleID = source.readInt();
        articleTitle = source.readString();
        articleCategory = source.readString();
        articleSnippet = source.readString();
        articleFull = source.readString();
        imageURL = source.readString();

    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleCategory() {
        return articleCategory;
    }

    public void setArticleCategory(String articleCategory) {
        this.articleCategory = articleCategory;
    }


    public String getArticleSnippet() {
        return articleSnippet;
    }

    public void setArticleSnippet(String articleSnippet) {
        this.articleSnippet = articleSnippet;
    }

    public String getArticleFull() {
        return articleFull;
    }

    public void setArticleFull(String articleFull) {
        this.articleFull = articleFull;
    }
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String image) {
        this.imageURL = image;
    }

    public static ArrayList<Article> getArticleList1() {
        ArrayList<Article> articles = new ArrayList<>();
        articles.add(new Article(0,
                "How to choose the best bank and bank accounts with the highest interest?",
                "Savings",
                "Check your banks for online account options!",
                "Zero fees and high interest rates are impossible, right? Actually, no!\n" +
                        "\n" +
                        "Online banks often provide the best interest rates. Their overhead costs are minimal, and they don’t have to spend money on branches or marketing. Consequently, their customer service is better, and they can handle lower profit margins than traditional banks. They also offer interest rates six to 10 times higher than a conventional bank.\n" +
                        "\n" +
                        "Let’s say you put away $25,000. This would give you $750 in one year at a three percent interest rate at an online bank. Contrast this with a regular bank at a rate of 0.5 percent and you would get a meagre $125. Now imagine you saved $50,000. You'd receive $1,500 at an online bank and a paltry $250 at a regular bank!\n" +
                        "\n" +
                        "Next, get the best bank accounts. The minimum should be one checking account and one savings account.\n" +
                        "\n" +
                        "You need checking accounts for frequent withdrawals and savings accounts for goals like vacations or special events.\n" +
                        "\n" +
                        "You have a few choices here: have your checking and savings account at the same bank (the lazy option); have your checking account at a local bank and a savings account at an online bank (the normal choice); or numerous checking and savings accounts, the best choice for those who aren’t scared of effort and want to optimize their accounts for different goals.\n" +
                        "\n" +
                        "Or you can keep one and a half months of living expenses in your checking account and put everything else into your savings account.\n" +
                        "\n" +
                        "If having numerous accounts sounds like too much, then simply opt for a no-fees checking account at a local bank and a high interest rate savings account at an online bank.",
                "https://source.unsplash.com/FyD3OWBuXnY"));
        articles.add(new Article(1,
                "How much do you spend and how do you direct your money to where it needs to be?",
                "Savings",
                "Breaking down your expenditure into a plan, can help you save!",
                "Remember the last time you felt guilty about buying something, but bought it anyway? Next time you’ll know better after you learn how to spend consciously.\n" +
                        "\n" +
                        "Conscious spending is about reducing the amount of money you spend on things that aren’t so important to you and spending more on things that you really care about.\n" +
                        "\n" +
                        "All you need to do is adopt a Conscious Spending Plan. Automatically save and invest a given amount per month and spend the rest on whatever you want, guilt-free.\n" +
                        "\n" +
                        "The percentage you spend on different things can be broken down into:\n" +
                        "\n" +
                        "• 60 percent on fixed costs (rent, utilities, debt)\n" +
                        "\n" +
                        "• 10 percent on investments (Super)\n" +
                        "\n" +
                        "• 10 percent on savings (vacations, gifts, unexpected expenses)\n" +
                        "\n" +
                        "• 20 percent on guilt-free spending\n" +
                        "\n" +
                        "Conscious spending means thinking about what’s important to you. For example, the author's friend Jim moved to a smaller apartment after he got a raise. Why? His living space didn’t matter much to him, but he loved going camping, so he put his money towards that.\n" +
                        "\n" +
                        "Next, learn to adjust your spending.\n" +
                        "\n" +
                        "You can try “the envelope system,” in which you decide how much you wish to spend on the four areas above and put that money in envelopes, so when they’re empty, there’s no more spending for that month.\n" +
                        "\n" +
                        "“Envelopes” may also be metaphoric; the author's friend opened a bank account with a debit card that acted as an envelope. Each month she loads money onto the card for socializing and when the money’s gone, she doesn’t go out.\n" +
                        "\n" +
                        "Changing from one extreme behaviour takes a while, so tweak your spending rather than, for example, saving $495 a week if you were previously spending $500 a week. Choose one or two major problem areas and work on those, rather than trying to carve out 5 percent from numerous areas.\n" +
                        "\n" +
                        "Overdraft fees, for instance, can add up to over $1,000 per year. Erasing that alone will make a massive difference.",
                "https://source.unsplash.com/_wZaegHzdQc"));
        articles.add(new Article(2,
                "How to automate your money",
                "Savings",
                "Don’t let people tell you how to save and spend your money.\n" +
                        "\n" +
                        "You don’t need to scrimp and save on all the “right” or “acceptable” things. Instead, pick what’s really important for you to splurge or save on. For instance, if owning a collection of limited-edition sneakers is more important to you than dining out every week, scrimp on the dining and spend on the shoes!",
                "Automate your bill payments so you don't have to think about them.\n" +
                        "\n" +
                        "Paying bills is inconvenient and annoying. If you’re not crazy about managing money, create an automated system to do it for you.\n" +
                        "\n" +
                        "Take the Conscious Spending Plan and automate it using your bank and your own tools for tracking your spending.\n" +
                        "\n" +
                        "Conscious Spending Plan: automatically save and invest a given amount per month and spend the rest on whatever you want, guilt-free.\n" +
                        "\n" +
                        "The percentage you spend on different things can be broken down into:\n" +
                        "\n" +
                        "• 60 percent on fixed costs (rent, utilities, debt)\n" +
                        "\n" +
                        "• 10 percent on investments (Super)\n" +
                        "\n" +
                        "• 10 percent on savings (vacations, gifts, unexpected expenses)\n" +
                        "\n" +
                        "• 20 percent on guilt-free spending\n" +
                        "\n" +
                        "First, contact your bank to set up automatic transfers and payments.\n" +
                        "\n" +
                        "For example, set up automatic payments for fixed costs and automate withdrawals from your checking account to your Super.\n" +
                        "\n" +
                        "Once this is done, use the remaining money for spending and set mid-month calendar reminders to inform you if you’re exceeding your spending goals. A good idea is to also have $1,000 in your checking account as a reserve.\n" +
                        "\n" +
                        "If your spending is going according to plan, then great! If not, use the next 15 days to get back on track.\n" +
                        "\n" +
                        "Another excellent idea is to implement an Automatic Money Flow by connecting all your accounts and creating automatic transfers.\n" +
                        "\n" +
                        "The transfers can be organized in the following way:\n" +
                        "\n" +
                        "Your paycheck should fund your super and checking account, and your checking account should fund your savings account, credit card, fixed costs where you can’t use a credit card (like rent), and the odd amount of spending money. Your credit card should finance other fixed costs and guilt-free spending.\n" +
                        "\n" +
                        "But how exactly can you link all your accounts? Simply automate all transfers and payments:\n" +
                        "\n" +
                        "Say you get paid on the first of the month. On the second, automatically send a portion of your paycheck to your super and all that’s left over into your checking account. On the fifth, automatically transfer money to your savings account from your checking account. On the seventh, automatically pay off your bills and your credit card. ",
                "https://source.unsplash.com/na8l3EPqpvY"));
        articles.add(new Article(3,
                "Why Saving Money Is Important",
                "Savings",
                "If you don’t earn much and you can barely pay your bills, the idea of saving money might seem laughable. When you only have $5 left at the end of the month, why even bother to try saving? Because everyone has to start somewhere, and if you work at it, your financial situation is likely to improve over time. Saving money is worth the effort. It gives you peace of mind, it gives you options, and the more you save, the easier it becomes to accumulate additional savings.",
                "Peace of Mind\n"+
                        "\n" +
                        "As you accumulate savings, your financial worries should diminish, as long as you’re living within your means. If you already have next month’s rent taken care of by the first week of the current month, if you know you can get by without work for three to six months, if you have savings accounts for your children’s education and your own retirement that you’re regularly funding, you’ll sleep better at night.\n"+
                        "\n" +
                        "The reduced stress from having money in the bank frees up your energy for more enjoyable thoughts and activities. Finding the best savings account is key to making sure that the money that you do put away earns you the highest interest. \n" +
                        "\n"+
                        "Expanded Options\n"+
                        "\n" +
                        "The more money you have saved, the more you control your own destiny. If your job has you on the verge of a nervous breakdown, you can quit, even if you don’t have a new job lined up yet, and take time off to restore your sanity before you look for new employment. If you’re tired of living in an unsafe neighborhood, you can move to a safer area because you’ll have enough for a deposit on a better apartment or a down payment on a nicer home.\n"+
                        "\n" +
                        "If you get sick and need expensive healthcare that your insurance doesn’t cover, you’ll have a way to pay for it even though you can’t work while you’re getting treatment. And knowing that you have options because of the money you’ve socked away can give you even more peace of mind. \n"+
                        "\n" +
                        "No, money doesn’t solve every problem. If you are laid off, it might take as long as two years to find a new job. Some illnesses won’t go away no matter how many procedures you can afford, and random crime can happen even in a supposedly secure gated community. But with more money in the bank to deal with issues like these, you give yourself better odds of coming out on top. \n"+
                        "\n" +
                        "Money Working for You \n"+
                        "\n" +
                        "Most of us put in hundreds of hours of work each year to earn most of our money. But when you have savings and stash your funds in the right places, your money starts to work for you. Over time, you’ll need to work less and less as your money works more and more, and eventually, you might be able to stop working altogether. \n" +
                        "\n" +
                        "Once you’ve saved three to six months’ worth of expenses in your emergency fund, you can start saving money in a tax-advantaged retirement account. That’s where the magic starts to happen. If you have a high income and low expenses, you might accumulate enough to retire in 10 years. For most people, it takes closer to 40 years. \n"+
                        "\n" +
                        "But at some point, if you save and invest regularly, you should be able to live off the income generated by your investments—the saved money that’s working for you. The earlier you start, the more time a small amount of money has to grow large through the miracle of compounding. \n" +
                        "\n" +
                        "The Bottom Line\n" +
                        "\n" +
                        "Saving money is incredibly important. It gives you peace of mind, expands your options for decisions that have a major effect on your quality of life, and eventually gives you the option to retire. Most people who are wealthy got there through a combination of their own hard work and smart savings and investment decisions. You can become one of those people, too."
                        ,"https://source.unsplash.com/VO5w2Ida70s"));
        return articles;
    }

    public static ArrayList<Article> getArticleList2() {
        ArrayList<Article> articles = new ArrayList<>();
        articles.add(new Article(0,
                "How super works?",
                "Retirement",
                "Throughout your working life, check your super at least annually. Check your fund has the correct personal details and tax file number\n" +
                        "\n" +
                        "(TFN). Review your employer's contributions, and your account fees, investment options and insurance. If you’re not satisfied or don’t understand any details about your fund, call them and ask questions.",
                "You pay tax at reduced rate/or when you take it out.",
                "https://source.unsplash.com/cEukkv42O40"));
        articles.add(new Article(1,
                "How much super can I access under the Coronavirus Economic Response Package?",
                "Retirement",
                "The temporary measure will allow super account holders to access up to $10,000 of their money in this financial year, and a further $10,000 after 1 July, 2020 (until 30 June 2021).",
                "\n" +
                        "The temporary measure will allow super account holders to access up to $10,000 of their money in this financial year, and a further $10,000 after 1 July, 2020 (until 30 June 2021). These funds would not be taxed after they are withdrawn, according to details listed in the Bill. However, anyone who believes that they will need both these amounts need to apply within six months of the 20 April start of the scheme.\n" +
                        "\n" +
                        "The Australian Government has released details of what this scheme would entail:\n" +
                        "\n" +
                        "“While superannuation helps people save for retirement, the Government recognises that for those significantly financially affected by the Coronavirus, accessing some of their superannuation today may outweigh the benefits of maintaining those savings until retirement,” the ATO fact sheet states.\n" +
                        "\n" +
                        "“Eligible individuals will be able to apply online (from 20 April, 2020) through myGov to access up to $10,000 of their superannuation before 1 July 2020. They will also be able to access up to a further $10,000 from 1 July 2020 until 24 September 2020.”\n" +
                        "\n" +
                        "The ATO also states that “individuals will not need to pay tax on amounts released and the money they withdraw will not affect Centrelink or Veterans’ Affairs payments”.",
                "https://source.unsplash.com/-TRcaFMV5vk"));
        articles.add(new Article(2,
                "What insurance options does the superannuation fund offer?",
                "Retirement",
                "Many superannuation funds offer a level of personal insurance cover and the premiums can be cost-effective for some.",
                "Many superannuation funds offer a level of personal insurance cover and the premiums can be cost-effective for some workers, although it is worth knowing that the level of default cover may be limited should you need to make a claim in the future, and exclusions can apply. It is best to check the PDS and contact your super fund for further details. The types of insurance that may be included in your superannuation fund are:\n" +
                        "\n" +
                        "Life insurance – generally provides a lump sum payment to your beneficiaries upon your death.\n" +
                        "\n" +
                        "Total and Permanent Disability insurance –  pays you a lump sum if you become totally and permanently disabled.  The definition of total and permanent disability varies between insurance companies but it typically means that you are disabled to the extent that you will probably be unable to work again.\n" +
                        "\n" +
                        "Income Protection insurance – insures you for a set level of your income for a certain length of time in the event that you cannot work due to illness or injury. ",
                "https://source.unsplash.com/loeqHoa1uWY"));
        articles.add(new Article(3,
                "Does the superannuation fund have a good selection of investment options?",
                "Retirement",
                "Superannuation is an investment structure designed to give you a nest egg of savings for your retirement.",
                "\n" +
                        "Superannuation is an investment structure designed to give you a nest egg of savings for your retirement. It is the underlying investments that you choose to hold within that structure that will determine the performance of your investment. \n" +
                        "\n" +
                        "Those investments could range from cash, bonds, property, Australian shares or international shares, or could be a mixture of all these asset classes. Consider professional superannuation advice on what asset classes would suit your situation, and ensure that your superannuation fund of choice has something suitable.",
                "https://source.unsplash.com/-TRcaFMV5vk"));
        return articles;
    }

    public static ArrayList<Article> getArticleList3() {
        ArrayList<Article> articles = new ArrayList<>();
        articles.add(new Article(0,
                "How to Invest Simply?",
                "Investment",
                "snippet",
                "gnore experts and invest the simple way.\n" +
                        "\n" +
                        "Experts are always going on about choosing stocks. But there’s a much simpler way to invest.\n" +
                        "\n" +
                        "Don’t believe the experts. Not one of them can consistently predict how funds or stocks will perform in the market over time.\n" +
                        "\n" +
                        "Much like Frederic Brochet’s 2001 study, which found that wine experts weren’t able to distinguish between wines, financial experts can’t always be trusted. This is because they can’t see the future. The reality is, no matter what they say, experts are frequently wrong.\n" +
                        "\n" +
                        "Daniel Solin, author of The Smartest Investment Book You'll Ever Read, described some research which revealed that 47 of 50 advisory firms persistently advised investors on shares in companies right up until the date they filed for bankruptcy!\n" +
                        "\n" +
                        "Therefore, bypass expertise, and opt for the simplest path to investing.\n" +
                        "\n" +
                        "Picture an investment pyramid in which each category has an asset class. That is, stocks, bonds, and cash are at the base, index and mutual funds are in the middle, and lifecycle funds are at the top.\n" +
                        "\n" +
                        "These investments become more complicated as you move down the pyramid, so the simplest approach is through automatic lifecycle funds, also known as age-based funds. Which aspects of the pyramid you invest in shifts depending on your age.\n" +
                        "\n" +
                        "For instance, if you are a 25-year-old, Vanguard Target Retirement 2050 offers 90 percent stocks and 10 percent bonds, but if you are 55, it offers only 63 percent stocks and 37 percent bonds.\n" +
                        "\n" +
                        "As you can see, in your twenties, more of your assets are in stocks. This is because you can afford to take the risk at this age. As you get older, the balance moves accordingly, and lifecycle funds make things easier by automatically adjusting for you.\n" +
                        "\n" +
                        "The great thing about lifestyle funds is that you only have to own one fund.",
                        "https://source.unsplash.com/7aBrZmwEQtg"));
        articles.add(new Article(1,
                "How to Start Investing in Stocks: A Beginner's Guide",
                "Investment",
                "Investing is a way to set aside money while you are busy with life and have that money work for you so that you can fully reap the rewards of your labor in the future.",
                "Investing is a way to set aside money while you are busy with life and have that money work for you so that you can fully reap the rewards of your labor in the future. Investing is a means to a happier ending. Legendary investor Warren Buffett defines investing as …the process of laying out money now to receive more money in the future. The goal of investing is to put your money to work in one or more types of investment vehicles in the hopes of growing your money over time.\n"+
                "\n" +
                "Let's say that you have $1,000 set aside, and you're ready to enter the world of investing. Or maybe you only have $10 extra a week, and you'd like to get into investing. In this article, we'll walk you through getting started as an investor and show you how to maximize your returns while minimizing your costs.\n" +
                "\n" +
                "KEY TAKEAWAYS\n" +
                "\n" +
                "Investing is defined as the act of committing money or capital to an endeavor with the expectation of obtaining an additional income or profit.\n" +
                "\n" +
                "Unlike consuming, investing earmarks money for the future, hoping that it will grow over time.\n" +
                "\n" +
                "Investing, however, also comes with the risk for losses.\n" +
                "\n" +
                "Investing in the stock market is the most common way for beginners to gain investment experience.",
                "https://source.unsplash.com/UXEJDX4SqdE"));
        articles.add(new Article(
                2,
                "What Kind of Investor Are You?",
                "Investment",
                "Before you commit your money, you need to answer the question, what kind of investor am I? ",
                "Before you commit your money, you need to answer the question, what kind of investor am I? When opening a brokerage account, an online broker like Charles Schwab or Fidelity will ask you about your investment goals and how much risk you're willing to take on.\n" +
                        "\n" +
                        "Some investors want to take an active hand in managing their money's growth, and some prefer to set it and forget it. More traditional online brokers, like the two mentioned above, allow you to invest in stocks, bonds, exchange traded funds (ETFs), index funds, and mutual funds. ",
                "https://source.unsplash.com/XzUMBNmQro0"));
        articles.add(new Article(3,
                "Investing - Commissions and Fees",
                "Investment",
                "As economists like to say, there's no free lunch.",
                "\n" +
                        "As economists like to say, there's no free lunch. Though recently many brokers have been racing to lower or eliminate commissions on trades, and ETFs offer index investing to everyone who can trade with a bare-bones brokerage account, all brokers have to make money from their customers one way or another. \n" +
                        "\n" +
                        "In most cases, your broker will charge a commission every time that you trade stock, either through buying or selling. Trading fees range from the low end of $2 per trade but can be as high as $10 for some discount brokers. Some brokers charge no trade commissions at all, but they make up for it in other ways. There are no charitable organizations running brokerage services.\n" +
                        "\n" +
                        "Depending on how often you trade, these fees can add up and affect your profitability. Investing in stocks can be very costly if you hop into and out of positions frequently, especially with a small amount of money available to invest.\n" +
                        "\n" +
                        "Remember, a trade is an order to purchase or sell shares in one company. If you want to purchase five different stocks at the same time, this is seen as five separate trades, and you will be charged for each one.\n" +
                        "\n" +
                        "Now, imagine that you decide to buy the stocks of those five companies with your $1,000. To do this, you will incur $50 in trading costs—assuming the fee is $10—which is equivalent to 5% of your $1,000. If you were to fully invest the $1,000, your account would be reduced to $950 after trading costs. This represents a 5% loss before your investments even have a chance to earn.\n" +
                        "Should you sell these five stocks, you would once again incur the costs of the trades, which would be another $50. To make the round trip (buying and selling) on these five stocks would cost you $100, or 10% of your initial deposit amount of $1,000. If your investments do not earn enough to cover this, you have lost money by just entering and exiting positions.",
                "https://source.unsplash.com/OlSGcrLSYkw"));
        return articles;
    }
    public static ArrayList<Article> getArticleList4() {
        ArrayList<Article> articles = new ArrayList<>();
        articles.add(new Article(0,
                "How to use credit cards smartly?",
                "Credit Card",
                "Be smart with unexpected gifts.\n" +
                        "\n" +
                        "The next time you receive an unexpected monetary gift or bonus, such as a payrise, save 50 percent and spend the rest in whichever way you want. This way, you won’t get used to spending more than you can afford.",
                "Understanding how to harness the power of credit cards will be your first step towards saving money and getting rich.\n" +
                        "\n" +
                        "Our most significant purchases are often made on credit, and people with good credit are able to put aside a lot of money. Credit comes in the form of loans, mortgages and credit cards and it enables you to buy big purchases when you don’t have the money for them immediately.\n" +
                        "\n" +
                        "Keep in mind two central aspects of credit: a credit report, which records your credit activity and gives potential lenders information related to this, and a credit score, a number between 300 and 850 that denotes your credit risk to lenders.\n" +
                        "\n" +
                        "If your credit score is good, you’ll be attractive to lenders, which means they can grant you better loan interest rates. What’s even better about this is that a good credit score can save you hundreds of thousands of dollars in interest.\n" +
                        "\n" +
                        "For example, in 2009, the annual percentage rate in the USA showed that with a good credit score (750-850) on a $200,000 mortgage over 30 years, you'd pay $359,867, including interest. A bad credit score (620-639) would land you with $430,427 to pay. That’s $70,000 extra!\n" +
                        "\n" +
                        "The most important credit vehicle is credit cards. Here’s a couple of smart tips for successful credit handling:\n" +
                        "\n" +
                        "Kill your debt: reduce spending and pay it off! Punctual debt payments account for 35 percent of your credit score, so arranging automatic credit card payments will ensure you never skip a payment.\n" +
                        "\n" +
                        "Next, it’s worth contacting your credit card company and requesting they waive your annual fees and service charges and reduce your annual percentage rate. Surprisingly, many are willing to do so.\n" +
                        "\n" +
                        "Remember to seek out the best benefits you can from credit card companies. Some credit cards give you access to concierge services that may be able to book sold out tickets for shows, help you book your next travel adventure or even give additional travel insurance so that you and your loved ones are covered in case of an emergency."
                        ,"https://source.unsplash.com/_wZaegHzdQc"));
        articles.add(new Article(1,
                "Visa vs. MasterCard: What's the Difference?",
                "Credit Card",
                "Visa vs. MasterCard: An Overview",
                "The electronic payments industry is dominated by four companies. Visa, MasterCard, American Express, and Discover are responsible for handling the majority of the world’s card payments.1 Visa and MasterCard present unique offerings since neither company is involved with extending credit or issuing any cards. \n" +
                        "\n" +
                        "This means that all Visa and MasterCard payment cards are issued through some type of co-branded relationship. While the two companies don’t extend or issue any cards, they do partner to offer the broadest array of products encompassing credit, debit, and prepaid card options.\n" +
                        "\n" +
                        "Credit cards often dominate the headlines, with approximately $1 trillion in outstanding revolving credit balances as of Q4 2019.4 Consumers are easily familiar with debit cards, which along with credit cards and other forms of non-cash payments generate around $174.2 billion in transaction volume—representing $97.04 trillion in value—annually.\n" +
                        "\n" +
                        "As the financial technology market evolves, more and more prepaid card offerings are also being brought to market, generating around $200 billion in annual volume.",
                        "https://source.unsplash.com/pjwbiuwXy00"));
        articles.add(new Article(2,
                "The Pros of Opening a Credit Card",
                "Credit Card",
                "Opening a credit card means getting access to a revolving line of credit from the issuing bank. ",
                "Opening a credit card means getting access to a revolving line of credit from the issuing bank. The account comes with a predetermined credit limit based on the issuer’s assessment of your creditworthiness. As long as your outstanding balance stays within that limit, you can continue racking up charges.\n" +
                        "\n" +
                        "Having that additional payment option in your back pocket has its advantages. For one, you’ll have a safety net in case you face a short-term budget crunch. If you’re strapped for cash and your car needs a new set of brakes, you can simply open your wallet and charge it to your card.\n" +
                        "\n" +
                        "Even if you have plenty of funds in your savings account, using a card can be a great way to get rewards. Some products, such as Discover’s flagship card, Discover it®, offer cash-back benefits—typically as a percentage of the amount you charge. \n" +
                        "\n" +
                        "And, of course, cards that provide airline miles based on how you spend have long been a popular option among long-distance travelers. In recent years the number of reward programs has mushroomed, with banks offering discounts on everything from hotel stays to NFL merchandise.\n" +
                        "\n" +
                        "If you incur occasional job-related expenses—and don’t have a company-issued card—having a dedicated card for those expenses can be a godsend. It makes record-keeping a whole lot easier, and you won’t have to dig into your personal funds to, say, book a flight to another city for a meeting. Plus, you get to keep whatever rewards you accrue on your personal card.\n" +
                        "\n" +
                        "As long as your employer reimburses you by the due date, you won’t be charged interest. Just make sure you have a clear understanding of your employer’s reimbursement policy. The last thing you want to do is starting paying for lunch meetings that aren’t covered. \n" +
                        "\n" +
                        "Yet another reason to open your first card is to start building a credit history. Without a track record to go on, you’ll be seen as a higher risk when it comes time to take out a car or home loan.\n" +
                        "\n" +
                        "Credit cards report your payment history to the credit bureaus each month. If you’re able to hit your due dates consistently, you can do wonders for your credit score. You’ll do even better if you keep your credit utilization—the size of your balance in relation to your credit limit—fairly low. A utilization rate of under 30% for each account is considered ideal.\n" +
                        "\n" +
                        "The length of your credit history has a direct relationship to your credit score. The longer you hold onto an account, the better it’ll be for your score.",
                "https://source.unsplash.com/na8l3EPqpvY"));
        articles.add(new Article(3,
                "What You Risk When You Open a Credit Card",
                "Credit Card",
                "As convenient as it is to have an extra source of funds at your disposal, credit cards also carry significant potential risks.",
                "As convenient as it is to have an extra source of funds at your disposal, credit cards also carry significant potential risks. Most cards are an unsecured form of credit, meaning your debt isn’t backed up by any form of collateral. Because card issuers can’t recoup their expenses if you fail to pay down your balance, they tend to charge higher interest rates than other loans.\n" +
                        "\n" +
                        "That doesn’t matter much if you regularly pay your full balance from your due date. In that case you won’t pay a dime in interest. However, starting on your due date the bank will begin assessing finance charges based on the balance that you’ve carried over. \n" +
                        "\n" +
                        "The upshot is that you could be paying a lot of money to your issuing bank in finance charges alone. Let’s say you carry an average daily balance of $3,000 and have a 20% annual percentage rate (APR) on your card. You’ll be assessed $600 in interest alone every year. Some cards also charge a flat annual fee that makes them more expensive still.\n" +
                        "\n" +
                        "KEY TAKEAWAYS\n" +
                        "\n" +
                        "Credit cards can help you improve your credit score, but only if you use them responsibly.\n" +
                        "\n" +
                        "Your payment history and borrowing amount are the two biggest factors in your credit score.\n" +
                        "\n" +
                        "Secured credit cards are an option for borrowers with a poor credit history. ",
                        "https://source.unsplash.com/ECxwQjLRwLA"));
        return articles;
    }
}


