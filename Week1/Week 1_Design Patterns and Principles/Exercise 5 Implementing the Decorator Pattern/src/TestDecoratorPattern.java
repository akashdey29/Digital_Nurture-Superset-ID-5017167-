
public class TestDecoratorPattern {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        notifier.send("Hello World!");

        System.out.println("\nAdding SMS notification:");
        Notifier smsNotifier = new SMSNotifierDecorator(notifier);
        smsNotifier.send("Hello World!");

        System.out.println("\nAdding Slack notification:");
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);
        slackNotifier.send("Hello World!");
    }
}
