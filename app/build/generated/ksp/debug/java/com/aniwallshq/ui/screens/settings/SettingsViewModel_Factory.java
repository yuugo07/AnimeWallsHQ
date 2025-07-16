package com.aniwallshq.ui.screens.settings;

import com.aniwallshq.data.local.DataStoreManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
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
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
  private final Provider<DataStoreManager> dataStoreManagerProvider;

  public SettingsViewModel_Factory(Provider<DataStoreManager> dataStoreManagerProvider) {
    this.dataStoreManagerProvider = dataStoreManagerProvider;
  }

  @Override
  public SettingsViewModel get() {
    return newInstance(dataStoreManagerProvider.get());
  }

  public static SettingsViewModel_Factory create(
      Provider<DataStoreManager> dataStoreManagerProvider) {
    return new SettingsViewModel_Factory(dataStoreManagerProvider);
  }

  public static SettingsViewModel newInstance(DataStoreManager dataStoreManager) {
    return new SettingsViewModel(dataStoreManager);
  }
}
