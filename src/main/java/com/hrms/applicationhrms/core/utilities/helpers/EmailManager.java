package com.hrms.applicationhrms.core.utilities.helpers;

import com.hrms.applicationhrms.business.constants.Messages;
import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Service;

@Service
public class EmailManager implements  EmailService{

    @Override
    public Result send(String receiver, String title, String message) {
        return new SuccessResult(Messages.verificationSent());
    }

}
