package com.gaurav.wallpapermaker.Stock;

import android.view.MotionEvent;
import android.view.SurfaceHolder;

import com.gaurav.wallpapermaker.LiveWallpaper.GLWallpaperService;

/**
 * @author jinyalin
 * @since 2017/7/24.
 */

public class AdvanceGLWallpaperService extends GLWallpaperService {
    @Override
    public Engine onCreateEngine() {
        return new AdvanceEngine();
    }

    private class AdvanceEngine extends GLEngine {
        AdvanceRenderer renderer;

        public AdvanceEngine() {
            super();
            renderer = new AdvanceRenderer(AdvanceGLWallpaperService.this);
            setRenderer(renderer);
            setRenderMode(RENDERMODE_CONTINUOUSLY);
        }

        @Override
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);

            setTouchEventsEnabled(true);
        }

        @Override
        public void onTouchEvent(MotionEvent event) {
            super.onTouchEvent(event);
            renderer.onTouchEvent(event);
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            if (renderer != null) {
                renderer.release();
            }
            renderer = null;
        }
    }
}
