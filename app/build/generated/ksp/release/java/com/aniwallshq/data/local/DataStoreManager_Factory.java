package com.aniwallshq.data.local;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class DataStoreManager_Factory implements Factory<DataStoreManager> {
  private final Provider<Context> appContextProvider;

  public DataStoreManager_Factory(Provider<Context> appContextProvider) {
    this.appContextProvider = appContextProvider;
  }

  @Override
  public DataStoreManager get() {
    return newInstance(appContextProvider.get());
  }

  public static DataStoreManager_Factory create(Provider<Context> appContextProvider) {
    return new DataStoreManager_Factory(appContextProvider);
  }

  public static DataStoreManager newInstance(Context appContext) {
    return new DataStoreManager(appContext);
  }
}
