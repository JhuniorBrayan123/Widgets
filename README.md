# Widgets
# 📱 Widget Dashboard con Glance - Android

## 📋 Descripción del Proyecto

Aplicación Android que implementa widgets modernos utilizando **Jetpack Glance** y **Material Design 3**. El proyecto incluye dos tipos de widgets: uno simple para navegación rápida y un dashboard completo con información en tiempo real, accesos directos y seguimiento de actividades.

---

## ✨ Características Principales

### 🎯 SimpleWidget
- Navegación rápida con 2 botones (Home y Work)
- Diseño minimalista y eficiente
- Tamaño compacto: 250x100dp

### 📊 DashboardWidget
- **Información en Tiempo Real**: Hora actual, fecha en español y estadísticas dinámicas
- **Accesos Rápidos**: Grid 2x2 con 4 botones de navegación directa
- **Última Actividad**: Registro de la acción más reciente con timestamp
- **Actualización Automática**: Refresco cada 30 minutos
- **Diseño Material 3**: Adaptación automática al tema del sistema

---

## 🛠️ Tecnologías Utilizadas

- **Lenguaje**: Kotlin
- **Framework de UI**: Jetpack Compose + Glance
- **Diseño**: Material Design 3
- **SDK Mínimo**: Android API 21+
- **Versión de Compilación**: Java 11

### Dependencias Principales
```gradle
implementation ("androidx.glance:glance-appwidget:1.1.0")
implementation ("androidx.glance:glance-material3:1.1.0")
```

---

## 📁 Estructura del Proyecto
```
app/src/main/
├── java/com/example/widgets/
│   ├── MainActivity.kt
│   ├── WorkActivity.kt
│   ├── SimpleWidget.kt
│   ├── SimpleWidgetContent.kt
│   ├── DashboardWidget.kt
│   └── DashboardWidgetContent.kt
├── res/
│   ├── xml/
│   │   ├── simple_widget_info.xml
│   │   └── dashboard_widget_info.xml
│   └── layout/
└── AndroidManifest.xml
```

---

## 🎨 Principios de Diseño Aplicados

### Material Design 3
- **Colores del sistema**: `GlanceTheme.colors`
- **Tipografía escalada**: 
  - Títulos: 20sp (Bold)
  - Subtítulos: 14sp (Medium)
  - Cuerpo: 12sp (Regular)

### Espaciado Consistente
- Padding general: 16dp
- Padding interno: 12dp
- Separación entre elementos: 8dp
- Border radius: 12dp

### Contenedores Diferenciados
- `primaryContainer`: Información temporal
- `secondaryContainer`: Última actividad
- `background`: Fondo principal

---

## 🚀 Instalación y Configuración

### Requisitos Previos
- Android Studio Hedgehog | 2023.1.1 o superior
- JDK 11 o superior
- Dispositivo/Emulador con Android 5.0 (API 21) o superior

### Pasos de Instalación

1. **Clonar el repositorio**
```bash
git clone https://github.com/tu-usuario/widgets-dashboard.git
cd widgets-dashboard
```

2. **Abrir en Android Studio**
   - File → Open → Seleccionar la carpeta del proyecto

3. **Sincronizar Gradle**
   - Click en "Sync Now" cuando aparezca la notificación

4. **Ejecutar la aplicación**
   - Click en el botón "Run" o presiona `Shift + F10`

### Configuración de Gradle

**build.gradle (Module: app)**
```gradle
android {
    compileSdk = 34
    
    defaultConfig {
        minSdk = 21
        targetSdk = 34
    }
    
    buildFeatures {
        compose = true
    }
    
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation ("androidx.glance:glance-appwidget:1.1.0")
    implementation ("androidx.glance:glance-material3:1.1.0")
    // Otras dependencias...
}
```

---

## 📱 Uso de los Widgets

### Agregar Widgets a la Pantalla de Inicio

1. **Mantén presionado** un espacio vacío en la pantalla de inicio
2. Selecciona **"Widgets"**
3. Busca la aplicación **"Widgets"**
4. Verás dos opciones:
   - **SimpleWidget**: Widget compacto con 2 botones
   - **DashboardWidget**: Dashboard completo
5. **Arrastra** el widget deseado a la pantalla de inicio

### Funcionalidades de los Botones

**SimpleWidget:**
- `Home`: Abre MainActivity
- `Work`: Abre WorkActivity

**DashboardWidget:**
- `🏠 Home`: Navega a la pantalla principal
- `💼 Work`: Accede a la sección de trabajo
- `⚙️ Config`: Configuración (MainActivity)
- `📊 Stats`: Estadísticas (MainActivity)

---

## 🔧 Problemas Comunes y Soluciones

### Error: `kotlinCompilerExtensionVersion` no encontrado
**Solución**: Verificar que esté dentro del bloque `composeOptions`, no `compileOptions`

### Error: Widget no aparece en la lista
**Solución**: 
1. Desinstalar la aplicación completamente
2. Recompilar (`Build → Clean Project` → `Build → Rebuild Project`)
3. Reinstalar la aplicación

### Error: Widget no se actualiza
**Solución**: 
- Quitar el widget de la pantalla de inicio
- Volver a agregarlo desde la lista de widgets

### Error: `actionStartActivity` con tipo incorrecto
**Solución**: Usar genéricos en tiempo de compilación:
```kotlin
// ❌ Incorrecto
onClick = actionStartActivity(activity)

// ✅ Correcto
onClick = actionStartActivity<MainActivity>()
```

---

## 📊 Comparativa de Widgets

| Característica | SimpleWidget | DashboardWidget |
|----------------|--------------|-----------------|
| **Tamaño** | 250x100dp | 250x200dp |
| **Botones** | 2 | 4 |
| **Información dinámica** | No | Sí (hora, fecha, stats) |
| **Diseño** | Minimalista | Material 3 completo |
| **Actualización** | - | Cada 30 minutos |
| **Casos de uso** | Accesos rápidos | Dashboard completo |

---

## 💡 Conceptos Clave

### Glance vs Views Tradicionales

| Aspecto | Views XML | Glance |
|---------|-----------|--------|
| **Lenguaje** | XML + Java/Kotlin | Kotlin (Compose) |
| **API** | RemoteViews | Compose API |
| **Mantenimiento** | Complejo | Simple |
| **Flexibilidad** | Limitada | Alta |

### Actualización de Widgets
- **Frecuencia mínima**: 30 minutos (1,800,000 ms)
- Configurado en `updatePeriodMillis` del archivo XML
- Para actualizaciones inmediatas, usar `WorkManager` o `BroadcastReceiver`

---

## 📝 Código de Referencia

### Formato de Fecha en Español
```kotlin
SimpleDateFormat("EEEE, dd MMM", Locale("es", "ES")).format(Date())
```

### Contenedores con Esquinas Redondeadas
```kotlin
GlanceModifier
    .background(GlanceTheme.colors.primaryContainer)
    .cornerRadius(12.dp)
    .padding(12.dp)
```

### Navegación entre Activities
```kotlin
Button(
    text = "🏠 Home",
    onClick = actionStartActivity<MainActivity>()
)
```

---

## 🎯 Ventajas del Proyecto

✅ **Acceso instantáneo** a funciones sin abrir la aplicación  
✅ **Información visible** permanentemente en pantalla de inicio  
✅ **Diseño profesional** siguiendo Android UI Kit  
✅ **Escalable**: Fácil agregar nuevas secciones  
✅ **Material 3**: Adaptación automática al tema del sistema  
✅ **Código modular**: Funciones organizadas y reutilizables  

---

## 🚀 Futuras Mejoras

- [ ] Integración con base de datos local (Room)
- [ ] Configuración personalizable del widget
- [ ] Widgets de diferentes tamaños (1x1, 2x2, 4x2)
- [ ] Animaciones y transiciones
- [ ] Temas personalizados
- [ ] Sincronización con servicios en la nube
- [ ] Notificaciones interactivas desde el widget

---

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Para cambios importantes:

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/NuevaCaracteristica`)
3. Commit tus cambios (`git commit -m 'Agregar nueva característica'`)
4. Push a la rama (`git push origin feature/NuevaCaracteristica`)
5. Abre un Pull Request

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

---



## 📚 Recursos Adicionales

- [Documentación de Glance](https://developer.android.com/jetpack/compose/glance)
- [Material Design 3 para Compose](https://developer.android.com/jetpack/compose/designsystems/material3)
- [Codelab de Widgets](https://developer.android.com/codelabs/basic-android-kotlin-compose-widgets)

---

**⭐ Si este proyecto te fue útil, considera darle una estrella en GitHub!**
