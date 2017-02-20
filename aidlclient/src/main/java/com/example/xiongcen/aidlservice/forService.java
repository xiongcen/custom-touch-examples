/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/xiongcen/AndroidStudioProjects/local_news_android/aidlservice/src/main/aidl/com/example/xiongcen/aidlservice/forService.aidl
 */
package com.example.xiongcen.aidlservice;

public interface forService extends android.os.IInterface {
    /**
     * Local-side IPC implementation stub class.
     */
    public static abstract class Stub extends android.os.Binder implements forService {
        private static final String DESCRIPTOR = "com.example.xiongcen.aidlservice.forService";

        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an com.example.xiongcen.aidlservice.forService interface,
         * generating a proxy if needed.
         */
        public static forService asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof forService))) {
                return ((forService) iin);
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
                case TRANSACTION_registerTestCall: {
                    data.enforceInterface(DESCRIPTOR);
                    forActivity _arg0;
                    _arg0 = forActivity.Stub.asInterface(data.readStrongBinder());
                    this.registerTestCall(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_invokCallBack: {
                    data.enforceInterface(DESCRIPTOR);
                    this.invokCallBack();
                    reply.writeNoException();
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements forService {
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
            public void registerTestCall(forActivity cb) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((cb != null)) ? (cb.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_registerTestCall, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void invokCallBack() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_invokCallBack, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_registerTestCall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_invokCallBack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    }

    public void registerTestCall(forActivity cb) throws android.os.RemoteException;

    public void invokCallBack() throws android.os.RemoteException;
}
