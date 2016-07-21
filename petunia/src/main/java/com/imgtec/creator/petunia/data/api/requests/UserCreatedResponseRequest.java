/*
 * <b>Copyright 2016 by Imagination Technologies Limited
 * and/or its affiliated group companies.</b>
 *
 * All rights reserved.  No part of this software, either
 * material or conceptual may be copied or distributed,
 * transmitted, transcribed, stored in a retrieval system
 * or translated into any human or computer language in any
 * form by any means, electronic, mechanical, manual or
 * other-wise, or disclosed to the third parties without the
 * express written permission of Imagination Technologies
 * Limited, Home Park Estate, Kings Langley, Hertfordshire,
 * WD4 8LZ, U.K.
 */

package com.imgtec.creator.petunia.data.api.requests;

import com.google.gson.GsonBuilder;
import com.imgtec.creator.petunia.data.api.pojo.UserCreatedResponse;
import com.imgtec.creator.petunia.data.api.pojo.UserData;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 *
 */
public class UserCreatedResponseRequest extends BaseRequest<UserCreatedResponse> {

  private final UserData data;

  public UserCreatedResponseRequest(String url, UserData data) {
    super(url);
    this.data = data;
  }

  @Override
  public Request prepareRequest() {
    final String json = new GsonBuilder().create().toJson(data);
    return new Request.Builder()
        .url(getUrl())
        .post(RequestBody.create(MediaType.parse("application/json"), json))
        .build();
  }
}