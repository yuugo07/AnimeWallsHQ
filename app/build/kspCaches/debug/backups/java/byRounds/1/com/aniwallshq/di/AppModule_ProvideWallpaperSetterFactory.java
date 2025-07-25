package com.aniwallshq.di;

import android.content.Context;
import com.aniwallshq.util.WallpaperSetter;
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
public final class AppModule_ProvideWallpaperSetterFactory implements Factory<WallpaperSetter> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideWallpaperSetterFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public WallpaperSetter get() {
    return provideWallpaperSetter(contextProvider.get());
  }

  public static AppModule_ProvideWallpaperSetterFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvideWallpaperSetterFactory(contextProvider);
  }

  public static WallpaperSetter provideWallpaperSetter(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideWallpaperSetter(context));
  }
}
