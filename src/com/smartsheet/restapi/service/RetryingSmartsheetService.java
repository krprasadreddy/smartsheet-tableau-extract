/**
 *    Copyright 2013 Smartsheet.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * 
 */
package com.smartsheet.restapi.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.smartsheet.platform.tableau.exceptions.ServiceUnavailableException;
import com.smartsheet.platform.tableau.model.Attachment;
import com.smartsheet.platform.tableau.model.Sheet;
import com.smartsheet.platform.tableau.model.User;

/**
 * A wrapper around a {@link SmartsheetService} delegate which retries when
 * the delegate fails with {@link ServiceUnavailableException}.
 * <p>
 * Used to encapsulate the retry algorithm from a client of the
 * {@link SmartsheetService} delegate. The client simply calls the wrapper
 * unaware of retry attempts being made on the delegate as necessary.
 */
public class RetryingSmartsheetService implements SmartsheetService {

    private static final int MAX_RETRIES = 5;
    private static final int WAIT_INTERVAL_SECS = 5;

    private final SmartsheetService delegateService;

    public RetryingSmartsheetService(SmartsheetService delegateService) {
        this.delegateService = delegateService;
    }

    public List<User> getUsers() throws Exception {
        ServiceUnavailableException finalException = null;

        for (int i = 0; i <= MAX_RETRIES; i++) {
            try {
                return delegateService.getUsers();

            } catch (ServiceUnavailableException e) {
                if (i < MAX_RETRIES)
                    sleepForDefinedInterval(i+1, "getUsers");
                else
                    finalException = e;
            }
        }

        throw finalException;
    }
    public List<Sheet> getSheets() throws Exception {
    	ServiceUnavailableException finalException = null;
    	
    	for (int i = 0; i <= MAX_RETRIES; i++) {
    		try {
    			return delegateService.getSheets();
    			
    		} catch (ServiceUnavailableException e) {
    			if (i < MAX_RETRIES)
    				sleepForDefinedInterval(i+1, "getUsers");
    			else
    				finalException = e;
    		}
    	}
    	
    	throw finalException;
    }


    public Sheet getSheetDetails(long sheetId) throws Exception {
        ServiceUnavailableException finalException = null;

        for (int i = 0; i <= MAX_RETRIES; i++) {
            try {
                return delegateService.getSheetDetails(sheetId);

            } catch (ServiceUnavailableException e) {
                if (i < MAX_RETRIES)
                    sleepForDefinedInterval(i+1, "getSheetDetails");
                else
                    finalException = e;
            }
        }

        throw finalException;
    }

    public Attachment getAttachmentDetails(long attachmentId) throws Exception {
        ServiceUnavailableException finalException = null;

        for (int i = 0; i <= MAX_RETRIES; i++) {
            try {
                return delegateService.getAttachmentDetails(attachmentId);

            } catch (ServiceUnavailableException e) {
                if (i < MAX_RETRIES)
                    sleepForDefinedInterval(i+1, "getAttachmentDetails");
                else
                    finalException = e;
            }
        }

        throw finalException;
    }

    public String getAccessToken() {
        return delegateService.getAccessToken();
    }


    private static void sleepForDefinedInterval(int retryNumber, String action) throws InterruptedException {
        int sleepSecs = retryNumber * WAIT_INTERVAL_SECS;
        Thread.sleep(TimeUnit.SECONDS.toMillis(sleepSecs));
    }

    public void assumeUser(String assumedUserEmail) {
        delegateService.assumeUser(assumedUserEmail);
    }

    public String getAssumedUser() {
        return delegateService.getAssumedUser();
    }
}
