package com.hrms.applicationhrms.core.adapters;

import com.hrms.applicationhrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    DataResult<?> save (MultipartFile file);

}
