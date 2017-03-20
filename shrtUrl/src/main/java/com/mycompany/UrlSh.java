package com.mycompany;


import com.mycompany.service.UrlMapService;
import org.apache.commons.cli.*;

/**
 * Main class that run's the app
 */
public class UrlSh {

    /**
     * @param args arguments to be displayed
     */
    public static void main(String[] args) {

        Options options = new Options();
        options.addOption(new Option("i", "url", true, "URL to be shortened"));
        options.addOption(new Option("s", "resolve", true, "Resolve short URL to original URL"));
        options.addOption(new Option("o", "custom", true, "Shorten a given URL to a URL with a specified alias"));

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);

            String resultUrl = getResultUrl(cmd);
            if (resultUrl != null) {
                System.out.println(resultUrl);
            } else {
                printHelp("Invalid program arguments!", options);
            }

        } catch (ParseException exception) {
            printHelp(exception.getMessage(), options);
        }

    }

    /**
     * Returns result url
     *
     * @param cmd the command line arguments
     * @return result url
     */
    private static String getResultUrl(CommandLine cmd) {

        UrlMapService service = UrlMapService.getInstance();
        String resultUrl = null;
        if (cmd.hasOption("i")) {

            String urlToChange = cmd.getOptionValue("i");

            if (cmd.hasOption("o")) {
                String customUrl = cmd.getOptionValue("o");

                try {
                    resultUrl = service.addUrl(urlToChange, customUrl);
                } catch (CustomUrlException customUrlException) {
                    return customUrlException.getMessage();
                }
            } else {
                resultUrl = service.addUrl(urlToChange);
            }
            service.saveData();

        } else if (cmd.hasOption("s")) {
            resultUrl = service.getUrl(cmd.getOptionValue("s"));
            if (resultUrl == null) {
                resultUrl = "Not found";
            }
        }

        return resultUrl;
    }

    /**
     * Prints help message
     *
     * @param message title message to be displayed
     * @param options the possible options to be displayed
     */
    private static void printHelp(String message, Options options) {
        new HelpFormatter().printHelp(message, options);
    }
}
