package com.example.sistemaacuicola

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sistemaacuicola.ui.theme.SistemaAcuicolaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SistemaAcuicolaTheme {
                MainContainerScreen()
            }
        }
    }
}

@Composable
fun MainContainerScreen() {
    var selectedTab by remember { mutableStateOf(0) }

    val bgColor = Color(0xFF0B132B)
    val navBarColor = Color(0xFF1C2541)
    val accentCyan = Color(0xFF00E5FF)
    val textGray = Color(0xFF8D99AE)

    Scaffold(
        containerColor = bgColor,
        bottomBar = {
            NavigationBar(
                containerColor = navBarColor
            ) {
                NavigationBarItem(
                    icon = { Text("🏠", fontSize = 18.sp) },
                    label = { Text("Inicio") },
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = accentCyan,
                        selectedTextColor = accentCyan,
                        unselectedIconColor = textGray,
                        unselectedTextColor = textGray,
                        indicatorColor = Color(0xFF0B132B)
                    )
                )
                NavigationBarItem(
                    icon = { Text("📊", fontSize = 18.sp) },
                    label = { Text("Sensores") },
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = accentCyan,
                        selectedTextColor = accentCyan,
                        unselectedIconColor = textGray,
                        unselectedTextColor = textGray,
                        indicatorColor = Color(0xFF0B132B)
                    )
                )
                NavigationBarItem(
                    icon = { Text("⚙️", fontSize = 18.sp) },
                    label = { Text("Ajustes") },
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = accentCyan,
                        selectedTextColor = accentCyan,
                        unselectedIconColor = textGray,
                        unselectedTextColor = textGray,
                        indicatorColor = Color(0xFF0B132B)
                    )
                )
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedTab) {
                0 -> DashboardScreen()
                1 -> SensoresScreen()
                2 -> ConfigScreen()
            }
        }
    }
}

@Composable
fun DashboardScreen() {
    val cardBgColor = Color(0xFF1C2541)
    val accentCyan = Color(0xFF00E5FF)
    val textWhite = Color(0xFFFFFFFF)
    val textGray = Color(0xFF8D99AE)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = "ACUATECH", color = accentCyan, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = "Dashboard - Monitoreo de Estanques", color = textGray, fontSize = 12.sp)
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = cardBgColor)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Actual", color = textGray, fontSize = 12.sp)
                    Text(text = "15,000L", color = textWhite, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Total", color = textGray, fontSize = 12.sp)
                    Text(text = "20,000L", color = textWhite, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Restante", color = textGray, fontSize = 12.sp)
                    Text(text = "5,000L", color = accentCyan, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Sensores y Estanques Activos", color = textWhite, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = cardBgColor)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "Tanque Principal (Tilapia)", color = textWhite, fontWeight = FontWeight.Bold)
                    Text(text = "75% Capacidad • 72 PSI", color = textGray, fontSize = 12.sp)
                }
                Surface(shape = RoundedCornerShape(16.dp), color = Color(0xFF00796B)) {
                    Text(text = " Óptimo ", modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp), color = Color.White, fontSize = 12.sp)
                }
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = cardBgColor)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "Zona Norte (Trucha)", color = textWhite, fontWeight = FontWeight.Bold)
                    Text(text = "62% Capacidad • 68 PSI", color = textGray, fontSize = 12.sp)
                }
                Surface(shape = RoundedCornerShape(16.dp), color = Color(0xFF388E3C)) {
                    Text(text = " Normal ", modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp), color = Color.White, fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
fun SensoresScreen() {
    val cardBgColor = Color(0xFF1C2541)
    val accentCyan = Color(0xFF00E5FF)
    val textWhite = Color(0xFFFFFFFF)
    val textGray = Color(0xFF8D99AE)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Módulo de Sensores", color = accentCyan, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))

        Card(
            modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = cardBgColor)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Sensor de Temperatura #1", color = textWhite, fontWeight = FontWeight.Bold)
                Text(text = "Valor Actual: 24.5 °C • Estado: Estable", color = textGray, fontSize = 12.sp)
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = cardBgColor)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Sensor de pH #2", color = textWhite, fontWeight = FontWeight.Bold)
                Text(text = "Valor Actual: 7.2 pH • Rango Óptimo", color = textGray, fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun ConfigScreen() {
    val cardBgColor = Color(0xFF1C2541)
    val accentCyan = Color(0xFF00E5FF)
    val textWhite = Color(0xFFFFFFFF)
    val textGray = Color(0xFF8D99AE)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Configuración del Sistema", color = accentCyan, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))

        Card(
            modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = cardBgColor)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Versión de la App", color = textWhite, fontWeight = FontWeight.Bold)
                Text(text = "AcuaTech v1.0.0 (SENA ADSO)", color = textGray, fontSize = 12.sp)
            }
        }
    }
}