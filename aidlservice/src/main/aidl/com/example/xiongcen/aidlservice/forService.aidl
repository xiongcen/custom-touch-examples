// forService.aidl
package com.example.xiongcen.aidlservice;

// Declare any non-default types here with import statements
import com.example.xiongcen.aidlservice.forActivity;
interface forService {
     void registerTestCall(forActivity cb);
     void invokCallBack();
}
