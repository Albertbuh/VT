package services;

import services.impl.ClientServiceImpl;
import services.impl.TokenServiceImpl;
import services.impl.TradeServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory factory = new ServiceFactory();
    private final ClientService clientService = new ClientServiceImpl();
    private final TokenService tokenService = new TokenServiceImpl();
    private final TradeService tradeService = new TradeServiceImpl();
    public static ServiceFactory getInstance() {
        return factory;
    }

    public ClientService getClientService() {
        return clientService;
    }
    public TokenService getTokenService() { return tokenService; }
    public TradeService getTradeService() { return tradeService; }
}
