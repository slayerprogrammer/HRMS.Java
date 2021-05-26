package com.hrms.applicationhrms.core.utilities.helpers;

import com.hrms.applicationhrms.core.utilities.results.Result;

public interface EmailService {

    Result send(String receiver,String title, String message);

}
