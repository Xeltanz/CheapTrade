package hu.elte.alkfejl.cheaptrade.service;

public interface NotificationService {
    /**
     * Email küldés
     *
     * @param address címre
     * @param subject tárgy
     * @param text    szöveg
     */
    void sendEmail(String address, String subject, String text);
}
