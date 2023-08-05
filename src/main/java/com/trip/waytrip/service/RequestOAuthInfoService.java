package com.trip.waytrip.service;

import com.trip.waytrip.oauth.OAuthApiClient;
import com.trip.waytrip.oauth.OAuthInfoResponse;
import com.trip.waytrip.oauth.OAuthLoginParams;
import org.springframework.stereotype.Component;

@Component
public class RequestOAuthInfoService {
    private final OAuthApiClient client;

    public RequestOAuthInfoService(OAuthApiClient client) {
        this.client = client;
    }

    public OAuthInfoResponse request(OAuthLoginParams params) {
        String accessToken = client.requestAccessToken(params);
        return client.requestOauthInfo(accessToken);
    }
}