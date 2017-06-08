/*
 * Copyright (C) 2017 Pss1suporte
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package factoryPattern;


import factoryPattern.controller.AnalyzerController;

/**
 * Classe principal para o processamento do Teste do
 * processo seletivo da empresa NetLex.
 *
 * @author Paulo Sérgio da Silva
 * @email pss1suporte@gmail.com
 * @since 0.1
 */

public class Principal {
	public static String fileLogger = "testeNetLex_" + Principal.class.getName() + ".log";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnalyzerController netLexCal = new AnalyzerController(args);
		netLexCal.processFiles();
	}

}
//br.com.testeNetLex.Main
