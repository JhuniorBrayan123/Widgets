package com.example.widgets

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.appwidget.cornerRadius
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.width
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DashboardWidgetContent : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                DashboardContent()
            }
        }
    }

    @Composable
    private fun DashboardContent() {
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(GlanceTheme.colors.background)
                .padding(16.dp),
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.Start
        ) {
            // Header con título
            HeaderSection()

            Spacer(modifier = GlanceModifier.height(12.dp))

            // Información en tiempo real
            TimeInfoSection()

            Spacer(modifier = GlanceModifier.height(16.dp))

            // Accesos rápidos
            QuickActionsSection()

            Spacer(modifier = GlanceModifier.height(12.dp))

            // Última actividad
            LastActivitySection()
        }
    }

    @Composable
    private fun HeaderSection() {
        Row(
            modifier = GlanceModifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "📊 Dashboard",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = GlanceTheme.colors.onBackground
                )
            )
        }
    }

    @Composable
    private fun TimeInfoSection() {
        val currentTime = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
        val currentDate = SimpleDateFormat("EEEE, dd MMM", Locale("es", "ES")).format(Date())

        Column(
            modifier = GlanceModifier
                .fillMaxWidth()
                .background(GlanceTheme.colors.primaryContainer)
                .cornerRadius(12.dp)
                .padding(12.dp)
        ) {
            Text(
                text = "⏰ $currentTime",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = GlanceTheme.colors.onPrimaryContainer
                )
            )
            Spacer(modifier = GlanceModifier.height(4.dp))
            Text(
                text = currentDate,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = GlanceTheme.colors.onPrimaryContainer
                )
            )
            Spacer(modifier = GlanceModifier.height(8.dp))
            Text(
                text = "📈 Tareas completadas: 5/8",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = GlanceTheme.colors.onPrimaryContainer
                )
            )
        }
    }

    @Composable
    private fun QuickActionsSection() {
        Text(
            text = "Accesos Rápidos",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = GlanceTheme.colors.onBackground
            ),
            modifier = GlanceModifier.padding(bottom = 8.dp)
        )

        // Grid de botones 2x2
        Column {
            Row(
                modifier = GlanceModifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    text = "🏠 Home",
                    onClick = actionStartActivity<MainActivity>(),
                    modifier = GlanceModifier.width(140.dp).height(48.dp)
                )
                Spacer(modifier = GlanceModifier.width(8.dp))
                Button(
                    text = "💼 Work",
                    onClick = actionStartActivity<WorkActivity>(),
                    modifier = GlanceModifier.width(140.dp).height(48.dp)
                )
            }
            Spacer(modifier = GlanceModifier.height(8.dp))
            Row(
                modifier = GlanceModifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    text = "⚙️ Config",
                    onClick = actionStartActivity<MainActivity>(),
                    modifier = GlanceModifier.width(140.dp).height(48.dp)
                )
                Spacer(modifier = GlanceModifier.width(8.dp))
                Button(
                    text = "📊 Stats",
                    onClick = actionStartActivity<MainActivity>(),
                    modifier = GlanceModifier.width(140.dp).height(48.dp)
                )
            }
        }
    }

    @SuppressLint("RestrictedApi")
    @Composable
    private fun LastActivitySection() {
        Column(
            modifier = GlanceModifier
                .fillMaxWidth()
                .background(GlanceTheme.colors.secondaryContainer)
                .cornerRadius(12.dp)
                .padding(12.dp)
        ) {
            Text(
                text = "Última Actividad",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = GlanceTheme.colors.onSecondaryContainer
                )
            )
            Spacer(modifier = GlanceModifier.height(6.dp))
            Text(
                text = "✓ Tarea completada",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = GlanceTheme.colors.onSecondaryContainer
                )
            )
            Text(
                text = "Hace 5 minutos",
                style = TextStyle(
                    fontSize = 11.sp,
                    color = ColorProvider(androidx.compose.ui.graphics.Color.Gray)
                )
            )
        }
    }
}