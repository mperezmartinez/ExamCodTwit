/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examcodtwit;

import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Miguel
 */
public class MetodosTwit {

    Twitter twitter;

    /**
     * Constructor, da acceso a nuestra cuenta en twitter.
     */
    public MetodosTwit() {

        twitter = new TwitterFactory().getInstance();
    }

    /**
     * Nos da nuestro timeLine
     */
    public void timeLine() {

        try {
            List<Status> statuses = twitter.getHomeTimeline();
            System.out.println("Showing home timeline.");
            for (Status status : statuses) {
                System.out.println(status.getUser().getName() + ":"
                        + status.getText());
            }
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(MetodosTwit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Busca tweets con el texto introducido
     */
    public void busqueda() {

        try {

            String preg = JOptionPane.showInputDialog("Buscar:");
            Query query = new Query(preg);
            QueryResult result = twitter.search(query);
            for (Status status : result.getTweets()) {
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
            }
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(MetodosTwit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Publica un tweet que introducimos por JOptionPane
     */
    public void tweet() {
        try {

            String twet = JOptionPane.showInputDialog("Tweett:");
            Status status = twitter.updateStatus(twet);
            System.out.println("Successfully updated the status to [" + status.getText() + "].");
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(MetodosTwit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
