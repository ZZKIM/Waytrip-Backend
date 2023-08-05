package com.trip.waytrip.oauth;

public interface OAuthApiClient {
    String requestAccessToken(OAuthLoginParams params);
    OAuthInfoResponse requestOauthInfo(String accessToken);
}
