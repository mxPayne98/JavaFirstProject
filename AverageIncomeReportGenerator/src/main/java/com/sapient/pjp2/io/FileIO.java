package com.sapient.pjp2.io;

import com.sapient.pjp2.model.IncomeEntry;
import com.sapient.pjp2.model.ReportObject;

import java.io.File;
import java.util.List;

public interface FileIO {
    public List<IncomeEntry> read(String path);

    public File write(List<ReportObject> entries, String path);
}
