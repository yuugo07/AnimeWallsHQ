package com.aniwallshq.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.aniwallshq.data.local.model.WallpaperEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class WallpaperDao_Impl implements WallpaperDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WallpaperEntity> __insertionAdapterOfWallpaperEntity;

  private final SharedSQLiteStatement __preparedStmtOfClearAll;

  public WallpaperDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWallpaperEntity = new EntityInsertionAdapter<WallpaperEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `wallpapers` (`messageId`,`previewUrl`,`fullImageUrl`,`animeName`) VALUES (?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final WallpaperEntity entity) {
        statement.bindLong(1, entity.getMessageId());
        statement.bindString(2, entity.getPreviewUrl());
        statement.bindString(3, entity.getFullImageUrl());
        statement.bindString(4, entity.getAnimeName());
      }
    };
    this.__preparedStmtOfClearAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM wallpapers";
        return _query;
      }
    };
  }

  @Override
  public Object insertAll(final List<WallpaperEntity> wallpapers,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfWallpaperEntity.insert(wallpapers);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object clearAll(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearAll.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfClearAll.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<WallpaperEntity>> getWallpapers() {
    final String _sql = "SELECT * FROM wallpapers ORDER BY messageId DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"wallpapers"}, new Callable<List<WallpaperEntity>>() {
      @Override
      @NonNull
      public List<WallpaperEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
          final int _cursorIndexOfPreviewUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "previewUrl");
          final int _cursorIndexOfFullImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "fullImageUrl");
          final int _cursorIndexOfAnimeName = CursorUtil.getColumnIndexOrThrow(_cursor, "animeName");
          final List<WallpaperEntity> _result = new ArrayList<WallpaperEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WallpaperEntity _item;
            final int _tmpMessageId;
            _tmpMessageId = _cursor.getInt(_cursorIndexOfMessageId);
            final String _tmpPreviewUrl;
            _tmpPreviewUrl = _cursor.getString(_cursorIndexOfPreviewUrl);
            final String _tmpFullImageUrl;
            _tmpFullImageUrl = _cursor.getString(_cursorIndexOfFullImageUrl);
            final String _tmpAnimeName;
            _tmpAnimeName = _cursor.getString(_cursorIndexOfAnimeName);
            _item = new WallpaperEntity(_tmpMessageId,_tmpPreviewUrl,_tmpFullImageUrl,_tmpAnimeName);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<WallpaperEntity>> searchByAnimeName(final String query) {
    final String _sql = "SELECT * FROM wallpapers WHERE animeName LIKE '%' || ? || '%' ORDER BY messageId DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, query);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"wallpapers"}, new Callable<List<WallpaperEntity>>() {
      @Override
      @NonNull
      public List<WallpaperEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "messageId");
          final int _cursorIndexOfPreviewUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "previewUrl");
          final int _cursorIndexOfFullImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "fullImageUrl");
          final int _cursorIndexOfAnimeName = CursorUtil.getColumnIndexOrThrow(_cursor, "animeName");
          final List<WallpaperEntity> _result = new ArrayList<WallpaperEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WallpaperEntity _item;
            final int _tmpMessageId;
            _tmpMessageId = _cursor.getInt(_cursorIndexOfMessageId);
            final String _tmpPreviewUrl;
            _tmpPreviewUrl = _cursor.getString(_cursorIndexOfPreviewUrl);
            final String _tmpFullImageUrl;
            _tmpFullImageUrl = _cursor.getString(_cursorIndexOfFullImageUrl);
            final String _tmpAnimeName;
            _tmpAnimeName = _cursor.getString(_cursorIndexOfAnimeName);
            _item = new WallpaperEntity(_tmpMessageId,_tmpPreviewUrl,_tmpFullImageUrl,_tmpAnimeName);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
