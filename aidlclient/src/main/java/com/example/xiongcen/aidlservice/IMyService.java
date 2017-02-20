/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/xiongcen/AndroidStudioProjects/local_news_android/aidlservice/src/main/aidl/com/example/xiongcen/aidlservice/IMyService.aidl
 */
package com.example.xiongcen.aidlservice;

public interface IMyService extends android.os.IInterface {
    /**
     * Local-side IPC implementation stub class.
     */
    public static abstract class Stub extends android.os.Binder implements IMyService {
        private static final String DESCRIPTOR = "com.example.xiongcen.aidlservice.IMyService";

        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an com.example.xiongcen.aidlservice.IMyService interface,
         * generating a proxy if needed.
         */
        public static IMyService asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof IMyService))) {
                return ((IMyService) iin);
            }
            return new Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_getStudent: {
                    data.enforceInterface(DESCRIPTOR);
                    java.util.List<com.example.xiongcen.aidlservice.Student> _result = this.getStudent();
                    reply.writeNoException();
                    reply.writeTypedList(_result);
                    return true;
                }
                case TRANSACTION_addStudent: {
                    data.enforceInterface(DESCRIPTOR);
                    com.example.xiongcen.aidlservice.Student _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = com.example.xiongcen.aidlservice.Student.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    this.addStudent(_arg0);
                    reply.writeNoException();
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements IMyService {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote) {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override
            public java.util.List<com.example.xiongcen.aidlservice.Student> getStudent() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.util.List<com.example.xiongcen.aidlservice.Student> _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getStudent, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(com.example.xiongcen.aidlservice.Student.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void addStudent(com.example.xiongcen.aidlservice.Student student) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((student != null)) {
                        _data.writeInt(1);
                        student.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_addStudent, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_getStudent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_addStudent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    }

    public java.util.List<com.example.xiongcen.aidlservice.Student> getStudent() throws android.os.RemoteException;

    public void addStudent(com.example.xiongcen.aidlservice.Student student) throws android.os.RemoteException;
}
