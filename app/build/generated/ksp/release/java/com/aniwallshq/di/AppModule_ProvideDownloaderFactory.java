package com.aniwallshq.di;

import android.content.Context;
import com.aniwallshq.util.Downloader;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideDownloaderFactory implements Factory<Downloader> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideDownloaderFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public Downloader get() {
    return provideDownloader(contextProvider.get());
  }

  public static AppModule_ProvideDownloaderFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvideDownloaderFactory(contextProvider);
  }

  public static Downloader provideDownloader(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideDownloader(context));
  }
}
