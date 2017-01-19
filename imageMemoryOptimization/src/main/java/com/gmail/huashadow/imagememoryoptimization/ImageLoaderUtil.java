package com.gmail.huashadow.imagememoryoptimization;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 *
 * @author wolfXu
 *
 */

public class ImageLoaderUtil {

    private static final String TAG = ImageLoaderUtil.class.getSimpleName();

    public static void loadImages(final Context context, final List<ImageInfo> images,
                                  final OnImageLoadedListener onImageLoadedListener,
                                  final BitmapFactory.Options options) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (ImageInfo image : images) {
                    Bitmap bitmap = loadImage(context, image.downloadUrl, image.localPath, options);
                    onImageLoadedListener.onImageLoaded(bitmap, images.indexOf(image));
                }

            }
        });
        thread.start();
    }

    /**
     * 加载图片，优先加载本地图片，如果本地不存在，则从网络获取
     * @param context
     * @param downloadUrl
     * @param localPath
     * @return
     */
    public static Bitmap loadImage(Context context, String downloadUrl, String localPath,
                                   BitmapFactory.Options options) {
        File file = new File(localPath);
        Bitmap bitmap = null;
        if (file.exists()) {
            bitmap = BitmapFactory.decodeFile(file.getPath(), options);
            Log.i(TAG, "loadImage local image");
        } else if (downloadUrl != null && !downloadUrl.isEmpty()) {
            bitmap = loadNetImage(context, downloadUrl, options);
            if (bitmap != null) {
                try {
                    FileOutputStream outputStream = new FileOutputStream(new File(localPath));
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                    outputStream.flush();
                    outputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Log.i(TAG, "loadImage net image");
        }
        return bitmap;
    }

    private static Bitmap loadNetImage(Context context, String downloadUrl,
                                       BitmapFactory.Options options) {
        try {
            URL url = new URL(downloadUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream inputStream = conn.getInputStream();
            if ((conn.getResponseCode() == HttpURLConnection.HTTP_OK) ||
                    conn.getResponseCode() == HttpURLConnection.HTTP_NOT_MODIFIED) {
                return BitmapFactory.decodeStream(inputStream, null, options);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public interface OnImageLoadedListener {
        public void onImageLoaded(Bitmap bitmap, int index);
    }

    public static class ImageInfo {
        public String downloadUrl;
        public String localPath;

        public ImageInfo(String downloadUrl, String localPath) {
            this.downloadUrl = downloadUrl;
            this.localPath = localPath;
        }
    }
}


