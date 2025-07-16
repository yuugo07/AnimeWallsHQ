package com.aniwallshq.data;

import com.aniwallshq.data.local.dao.WallpaperDao;
import com.aniwallshq.data.remote.ApiService;
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
public final class WallpaperRepository_Factory implements Factory<WallpaperRepository> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<WallpaperDao> wallpaperDaoProvider;

  public WallpaperRepository_Factory(Provider<ApiService> apiServiceProvider,
      Provider<WallpaperDao> wallpaperDaoProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.wallpaperDaoProvider = wallpaperDaoProvider;
  }

  @Override
  public WallpaperRepository get() {
    return newInstance(apiServiceProvider.get(), wallpaperDaoProvider.get());
  }

  public static WallpaperRepository_Factory create(Provider<ApiService> apiServiceProvider,
      Provider<WallpaperDao> wallpaperDaoProvider) {
    return new WallpaperRepository_Factory(apiServiceProvider, wallpaperDaoProvider);
  }

  public static WallpaperRepository newInstance(ApiService apiService, WallpaperDao wallpaperDao) {
    return new WallpaperRepository(apiService, wallpaperDao);
  }
}
