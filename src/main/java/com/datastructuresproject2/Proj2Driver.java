package com.datastructuresproject2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Proj2Driver extends Application {
	private BSTDistrict districtTree;
	private FileChooser fChooser;
	private MenuBar menuBar;
	private Menu menu1, menu2, disMenu, locMenu, martMenu;
	private MenuItem openItem, item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, disInsert,
			disUpdate, disDelete, disNavigate, disWrFile, locInsert, locUpdate, locDelete, locNavigate, locSearch,
			martInsert, martUpdate, martDelete, martSearch;
	private Image image, image2;
	private ImageView imageView, imageView2;
	private BorderPane bdPane;
	private VBox vBoxMain, vBoxInstDis, vBoxChoUpdDis, vBoxUpdDis, vBoxNavDis, vBoxInstLoc, vBoxUpdLoc, vBoxInstMart,
			vBoxNavLoc, vBoxSeaLoc, vBoxSeaMart, vBoxUpdMart, vBoxDelMart;
	private HBox hBoxInstDis, hBoxChoUpdDis, hBoxUpdDis, hBoxUpdDis2, hBoxNavDis, hBoxNavDis1, hBoxInstDisLoc,
			hBoxInstLoc, hBoxInstMart, hBox1, hBoxNavLoc, hBoxSeaDisLoc, hBoxSeaLoc, hBoxDatesNav, hBoxNavLoc2;
	private GridPane gdPane, gdPane1, gdPaneMartSea, gdPaneMartUpd, gdPaneMartDel;
	private Label lblMainInst, lblMainInfo, lblDisInst, lblDisInstInfo, lblDisUpdChoInfo, lblDisUpdOld, lblDisUpdNew,
			lblDisUpdInfo, lblDisNavInfo, lblLocDisInst, lblLocInst, lblLocInstInfo, lblLocDisUpd, lblOldLocUpd,
			lblNewLocUpd, lblLocUpdInfo, lblMartInstInfo, lblMartName, lblMartDate, lblMartAge, lblMartLoc, lblMartDis,
			lblMartGender, lblLocDisNavInfo, lblLocNavInfo, lblLocDisSea, lblLocSea, lblLocSeaInfo, lblMartDisSea,
			lblMartLocSea, lblMartLocDateSea, lblMartSea, lblMartSeaInfo, lblMartDisUpd, lblMartLocUpd, lblOldMartUpd,
			lblMartDateUpd, lblMartUpdInfo, lblMartDisDel, lblMartLocDel, lblMartDel, lblMartDateDel, lblMartDelInfo;
	private TextField txtFieldDisInst, txtDisUpdOld, txtDisUpdNew, txtLocDisInst, txtLocInst, txtLocDisUpd,
			txtOldLocUpd, txtNewLocUpd, txtMartName, txtMartDate, txtMartAge, txtMartLoc, txtMartDis, txtLocDisSea,
			txtLocSea, txtMartDisSea, txtMartLocSea, txtMartSea, txtMartDisUpd, txtMartLocUpd, txtOldMartUpd,
			txtMartDateUpd, txtMartDisDel, txtMartLocDel, txtMartDel, txtMartDateDel;
	private TextArea txtAreaMain, txtAreaDisNavigation, txtAreaLocSearch, txtAreaMartSearch, txtAreaMartDelete,
			txtAreaMartUpd, txtAreaDisNav;
	private Button btDisInst, btDisInstMain, btDisChoUpd, btDisChoRen, btDisUpd, btDisUpdMain, btDisNavNext,
			btDisNavPrev, btDisNavLoad, btDisNavMain, btLocInst, btLocInstMain, btLocUpd, btLocUpdMain, btMartInst,
			btMartClear, btMartInstMain, btDisLocNavNext, btDisNavLocPrev, btLocNavLoad, btLocNavMain, btLocSeaMain,
			btMartSea, btMartSeaMain, btMartUpd, btMartUpdMain, btMartCheckDel, btMartDel, btMartDelMain,
			btMartCheckUpd, btDisChoMain, btDatesNavPrev, btDatesNavNext;
	private RadioButton rbMale, rbFemale, rbUnknown;
	private ToggleGroup group;
	private ComboBox<String> disCmBox, locCmBox, martDateCmBox;
	private ArrayList<String> disNames, locNames, datesNames;
	private boolean success;
	private Scene sceneMain;
	private DatePicker datePicker;
	private BSTLocationNode currentLocation;
	private String current, currentDate, tempDateNavData;
	private LinkedListStack forwardStack, forwardStackDates;
	private BSTDistrictNode currentDistrict;
	private TableView<Martyr> tableViewMartyrSearch, tableViewDatesNavigation;
	private File f;

	@Override
	public void start(Stage primaryStage) {
		districtTree = new BSTDistrict();

		// Panes
		bdPane = new BorderPane();
		vBoxMain = new VBox(20);
		vBoxMain.setAlignment(Pos.CENTER);
		vBoxMain.setPadding(new Insets(10, 10, 10, 10));
		vBoxInstDis = new VBox(20);
		vBoxInstDis.setAlignment(Pos.CENTER);
		vBoxInstDis.setPadding(new Insets(10, 10, 10, 10));
		hBoxInstDis = new HBox(20);
		hBoxInstDis.setAlignment(Pos.CENTER);
		hBoxInstDis.setPadding(new Insets(10, 10, 10, 10));
		vBoxChoUpdDis = new VBox(20);
		vBoxChoUpdDis.setAlignment(Pos.CENTER);
		vBoxChoUpdDis.setPadding(new Insets(10, 10, 10, 10));
		hBoxChoUpdDis = new HBox(20);
		hBoxChoUpdDis.setAlignment(Pos.CENTER);
		hBoxChoUpdDis.setPadding(new Insets(10, 10, 10, 10));
		vBoxUpdDis = new VBox(20);
		vBoxUpdDis.setAlignment(Pos.CENTER);
		vBoxUpdDis.setPadding(new Insets(10, 10, 10, 10));
		hBoxUpdDis = new HBox(20);
		hBoxUpdDis.setAlignment(Pos.CENTER);
		hBoxUpdDis.setPadding(new Insets(10, 10, 10, 10));
		hBoxUpdDis2 = new HBox(20);
		hBoxUpdDis2.setAlignment(Pos.CENTER);
		hBoxUpdDis2.setPadding(new Insets(10, 10, 10, 10));
		vBoxNavDis = new VBox(20);
		vBoxNavDis.setAlignment(Pos.CENTER);
		vBoxNavDis.setPadding(new Insets(10, 10, 10, 10));
		hBoxNavDis = new HBox(20);
		hBoxNavDis.setAlignment(Pos.CENTER);
		hBoxNavDis.setPadding(new Insets(10, 10, 10, 10));
		hBoxNavDis1 = new HBox(30);
		hBoxNavDis1.setAlignment(Pos.CENTER);
		hBoxNavDis1.setPadding(new Insets(10, 10, 10, 10));
		vBoxInstLoc = new VBox(20);
		vBoxInstLoc.setAlignment(Pos.CENTER);
		vBoxInstLoc.setPadding(new Insets(10, 10, 10, 10));
		hBoxInstLoc = new HBox(20);
		hBoxInstLoc.setAlignment(Pos.CENTER);
		hBoxInstLoc.setPadding(new Insets(10, 10, 10, 10));
		hBoxInstDisLoc = new HBox(20);
		hBoxInstDisLoc.setAlignment(Pos.CENTER);
		hBoxInstDisLoc.setPadding(new Insets(10, 10, 10, 10));
		hBoxDatesNav = new HBox(20);
		hBoxDatesNav.setAlignment(Pos.CENTER);
		hBoxDatesNav.setPadding(new Insets(10, 10, 10, 10));
		vBoxUpdLoc = new VBox(20);
		vBoxUpdLoc.setAlignment(Pos.CENTER);
		vBoxUpdLoc.setPadding(new Insets(10, 10, 10, 10));
		gdPane = new GridPane();
		gdPane.setAlignment(Pos.CENTER);
		gdPane.setPadding(new Insets(10, 10, 10, 10));
		gdPane.setVgap(10);
		gdPane.setHgap(10);
		gdPane1 = new GridPane();
		gdPane1.setPadding(new Insets(20, 20, 20, 20));
		gdPane1.setAlignment(Pos.CENTER);
		gdPane1.setHgap(10);
		gdPane1.setVgap(10);
		gdPaneMartSea = new GridPane();
		gdPaneMartSea.setPadding(new Insets(20, 20, 20, 20));
		gdPaneMartSea.setAlignment(Pos.CENTER);
		gdPaneMartSea.setHgap(10);
		gdPaneMartSea.setVgap(10);
		vBoxInstMart = new VBox(20);
		vBoxInstMart.setAlignment(Pos.CENTER);
		vBoxInstMart.setPadding(new Insets(10, 10, 10, 10));
		hBoxInstMart = new HBox(20);
		hBoxInstMart.setAlignment(Pos.CENTER);
		hBoxInstMart.setPadding(new Insets(10, 10, 10, 10));
		hBox1 = new HBox(30);
		hBox1.setAlignment(Pos.CENTER);
		vBoxNavLoc = new VBox(30);
		vBoxNavLoc.setAlignment(Pos.CENTER);
		vBoxNavLoc.setPadding(new Insets(10, 10, 10, 10));
		hBoxNavLoc = new HBox(20);
		hBoxNavLoc.setAlignment(Pos.CENTER);
		hBoxNavLoc.setPadding(new Insets(10, 10, 10, 10));
		hBoxNavLoc2 = new HBox(20);
		hBoxNavLoc2.setAlignment(Pos.CENTER);
		hBoxNavLoc2.setPadding(new Insets(10, 10, 10, 10));
		hBoxSeaDisLoc = new HBox(20);
		hBoxSeaDisLoc.setAlignment(Pos.CENTER);
		hBoxSeaDisLoc.setPadding(new Insets(10, 10, 10, 10));
		hBoxSeaLoc = new HBox(20);
		hBoxSeaLoc.setAlignment(Pos.CENTER);
		hBoxSeaLoc.setPadding(new Insets(10, 10, 10, 10));
		vBoxSeaLoc = new VBox(20);
		vBoxSeaLoc.setAlignment(Pos.CENTER);
		vBoxSeaLoc.setPadding(new Insets(10, 10, 10, 10));
		vBoxSeaMart = new VBox(20);
		vBoxSeaMart.setAlignment(Pos.CENTER);
		vBoxSeaMart.setPadding(new Insets(10, 10, 10, 10));
		gdPaneMartUpd = new GridPane();
		gdPaneMartUpd.setPadding(new Insets(20, 20, 20, 20));
		gdPaneMartUpd.setAlignment(Pos.CENTER);
		gdPaneMartUpd.setHgap(10);
		gdPaneMartUpd.setVgap(10);
		vBoxUpdMart = new VBox(20);
		vBoxUpdMart.setAlignment(Pos.CENTER);
		vBoxUpdMart.setPadding(new Insets(10, 10, 10, 10));
		gdPaneMartDel = new GridPane();
		gdPaneMartDel.setPadding(new Insets(20, 20, 20, 20));
		gdPaneMartDel.setAlignment(Pos.CENTER);
		gdPaneMartDel.setHgap(10);
		gdPaneMartDel.setVgap(10);
		vBoxDelMart = new VBox(20);
		vBoxDelMart.setAlignment(Pos.CENTER);
		vBoxDelMart.setPadding(new Insets(10, 10, 10, 10));

		// Image
		image = new Image(getClass().getResource("pngfind.com-manila-folder-png-1353429.png").toExternalForm());
		imageView = new ImageView(image);
		imageView.setFitWidth(16);
		imageView.setFitHeight(16);

		image2 = new Image(getClass().getResource("Save-Button-PNG-Free-Image.png").toExternalForm());
		imageView2 = new ImageView(image2);
		imageView2.setFitWidth(16);
		imageView2.setFitHeight(16);

		// Menu
		menuBar = new MenuBar();
		menu1 = new Menu("File");
		menu2 = new Menu("Color");
		disMenu = new Menu("District");
		locMenu = new Menu("Location");
		martMenu = new Menu("Martyr");

		// MenuItem
		openItem = new MenuItem("Open");
		openItem.setGraphic(imageView);
		item1 = new MenuItem("Light Green");
		item1.setOnAction(e -> bdPane.setStyle("-fx-background-color: lightgreen"));
		item2 = new MenuItem("Baby Blue");
		item2.setOnAction(e -> bdPane.setStyle("-fx-background-color: lightblue"));
		item3 = new MenuItem("Biege");
		item3.setOnAction(e -> bdPane.setStyle("-fx-background-color: Cornsilk"));
		item4 = new MenuItem("Plum");
		item4.setOnAction(e -> bdPane.setStyle("-fx-background-color: PLUM"));
		item5 = new MenuItem("Salmon");
		item5.setOnAction(e -> bdPane.setStyle("-fx-background-color: salmon"));
		item6 = new MenuItem("Pink");
		item6.setOnAction(e -> bdPane.setStyle("-fx-background-color: lightpink"));
		item7 = new MenuItem("White");
		item7.setOnAction(e -> bdPane.setStyle("-fx-background-color: white"));
		item8 = new MenuItem("Aquamarine");
		item8.setOnAction(e -> bdPane.setStyle("-fx-background-color: AQUAMARINE"));
		item9 = new MenuItem("Deep Sky Blue");
		item9.setOnAction(e -> bdPane.setStyle("-fx-background-color: DEEPSKYBLUE"));
		item10 = new MenuItem("Medium Sea Green");
		item10.setOnAction(e -> bdPane.setStyle("-fx-background-color: MEDIUMSEAGREEN"));
		item11 = new MenuItem("Original color");
		item11.setOnAction(e -> bdPane.setStyle("-fx-background-color: whitesmoke"));
		disInsert = new MenuItem("Insert a new district");
		disUpdate = new MenuItem("Update a district");
		disDelete = new MenuItem("Delete a district");
		disNavigate = new MenuItem("Navigate districts");
		disWrFile = new MenuItem("Save As");
		disWrFile.setGraphic(imageView2);
		locInsert = new MenuItem("Insert a new location");
		locUpdate = new MenuItem("Update a location");
		locDelete = new MenuItem("Delete a location");
		locNavigate = new MenuItem("Navigate locations");
		locSearch = new MenuItem("Navigate dates");
		martInsert = new MenuItem("Insert a new martyr");
		martUpdate = new MenuItem("Update a martyr");
		martDelete = new MenuItem("Delete a martyr");
		martSearch = new MenuItem("Search for a martyr");
		menu1.getItems().addAll(openItem, disWrFile);
		disMenu.getItems().addAll(disInsert, disUpdate, disDelete, disNavigate);
		locMenu.getItems().addAll(locInsert, locUpdate, locDelete, locNavigate);
		martMenu.getItems().addAll(locSearch, martInsert, martUpdate, martDelete, martSearch);
		menu2.getItems().addAll(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11);
		menuBar.getMenus().addAll(menu1, disMenu, locMenu, martMenu, menu2);

		// Labels
		lblMainInst = new Label("     Martyr's Data Program\n\nPlease open a file to continue");
		lblMainInst.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));
		lblMainInfo = new Label("Choose Operation from the menus");
		lblMainInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		lblMainInfo.setVisible(false);
		lblDisInst = new Label("District Name: ");
		lblDisInst.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblDisInstInfo = new Label();
		lblDisInstInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblDisInstInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: green; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 2;");
		lblDisUpdOld = new Label("Old District Name: ");
		lblDisInst.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblDisUpdNew = new Label("New District Name: ");
		lblDisInst.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblDisUpdInfo = new Label();
		lblDisUpdInfo.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblDisUpdInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: green; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 2;");
		lblDisNavInfo = new Label();
		lblDisNavInfo.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblDisNavInfo.setStyle(
				"-fx-font-size: 24px; -fx-text-fill: green; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 2;");
		lblLocDisInst = new Label("District Name: ");
		lblLocDisInst.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblLocInstInfo = new Label();
		lblLocInstInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblLocInstInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: green; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 2;");
		lblLocInst = new Label("Location Name: ");
		lblLocInst.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblLocDisUpd = new Label("District Name: ");
		lblLocDisUpd.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblOldLocUpd = new Label("Old Location Name: ");
		lblOldLocUpd.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblNewLocUpd = new Label("New Location Name: ");
		lblNewLocUpd.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblLocUpdInfo = new Label();
		lblLocUpdInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblLocUpdInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: green; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 2;");
		lblMartInstInfo = new Label();
		lblMartInstInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblMartInstInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: green; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 2;");
		lblMartName = new Label("Name: ");
		lblMartName.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartDate = new Label("Date: ");
		lblMartDate.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartAge = new Label("Age: ");
		lblMartAge.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartLoc = new Label("Location: ");
		lblMartLoc.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartDis = new Label("District: ");
		lblMartDis.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartGender = new Label("Gender: ");
		lblMartGender.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblLocDisNavInfo = new Label();
		lblLocDisNavInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblLocDisNavInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: red; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: green; -fx-border-width: 1;");
		lblLocNavInfo = new Label();
		lblLocNavInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblLocNavInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: blue; -fx-font-weight: bold; -fx-background-color: transparent;");
		lblLocDisSea = new Label("District: ");
		lblLocDisSea.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblLocSea = new Label("Location: ");
		lblLocSea.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblLocSeaInfo = new Label();
		lblLocSeaInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblLocSeaInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: red; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: green; -fx-border-width: 1;");
		lblMartDisSea = new Label("District: ");
		lblMartDisSea.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartLocSea = new Label("Location: ");
		lblMartLocSea.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartSea = new Label("Martyr Name: ");
		lblMartSea.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartLocDateSea = new Label("Date of Death: ");
		lblMartLocDateSea.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartSeaInfo = new Label();
		lblMartSeaInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblMartSeaInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: red; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: green; -fx-border-width: 1;");
		lblMartDisUpd = new Label("District: ");
		lblMartDisUpd.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartLocUpd = new Label("Location: ");
		lblMartLocUpd.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblOldMartUpd = new Label("Old Martyr Name: ");
		lblOldMartUpd.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartDateUpd = new Label("Date of Death: ");
		lblMartDateUpd.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartUpdInfo = new Label();
		lblMartUpdInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblMartUpdInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: red; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: green; -fx-border-width: 1;");
		lblMartDisDel = new Label("District: ");
		lblMartDisDel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartLocDel = new Label("Location: ");
		lblMartLocDel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartDel = new Label("Martyr Name: ");
		lblMartDel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartDateDel = new Label("Date of Death: ");
		lblMartDateDel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartDelInfo = new Label();
		lblMartDelInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblMartDelInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: green; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 1;");
		lblDisUpdChoInfo = new Label("Choose whether you want to update or rename.");
		lblDisUpdChoInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblDisUpdChoInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: green; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 1;");

		// TextFields
		txtFieldDisInst = new TextField();
		txtFieldDisInst.setPromptText("e.g.: Al-Quds");
		txtDisUpdOld = new TextField();
		txtDisUpdOld.setPromptText("Old District Name");
		txtDisUpdNew = new TextField();
		txtDisUpdNew.setPromptText("New District Name");
		txtLocDisInst = new TextField();
		txtLocDisInst.setPromptText("e.g.: Al-Quds");
		txtLocInst = new TextField();
		txtLocInst.setPromptText("e.g.: a-Ram");
		txtLocDisUpd = new TextField();
		txtLocDisUpd.setPromptText("e.g.: Al-Quds");
		txtOldLocUpd = new TextField();
		txtOldLocUpd.setPromptText("Old Location Name");
		txtNewLocUpd = new TextField();
		txtNewLocUpd.setPromptText("New Location Name");
		txtMartName = new TextField();
		txtMartName.setPromptText("e.g.: Elias");
		txtMartDate = new TextField();
		txtMartDate.setPromptText("(MM/DD/YYYY)");
		txtMartAge = new TextField();
		txtMartAge.setPromptText("e.g.: 25");
		txtMartLoc = new TextField();
		txtMartLoc.setPromptText("e.g.: a-Ram");
		txtMartDis = new TextField();
		txtMartDis.setPromptText("e.g.: Al-Quds");
		txtLocDisSea = new TextField();
		txtLocDisSea.setPromptText("e.g.: Al-Quds");
		txtLocSea = new TextField();
		txtLocSea.setPromptText("e.g.: a-Ram");
		txtMartDisSea = new TextField();
		txtMartDisSea.setPromptText("e.g.: Al-Quds");
		txtMartLocSea = new TextField();
		txtMartLocSea.setPromptText("e.g.: a-Ram");
		txtMartSea = new TextField();
		txtMartSea.setPromptText("e.g.: Elias");
		txtMartDisUpd = new TextField();
		txtMartDisUpd.setPromptText("e.g.: Al-Quds");
		txtMartLocUpd = new TextField();
		txtMartLocUpd.setPromptText("e.g.: a-Ram");
		txtOldMartUpd = new TextField();
		txtOldMartUpd.setPromptText("e.g.: Elias");
		txtMartDateUpd = new TextField();
		txtMartDateUpd.setPromptText("e.g.: (MM/DD/YYYY)");
		txtMartDisDel = new TextField();
		txtMartDisDel.setPromptText("e.g.: Al-Quds");
		txtMartLocDel = new TextField();
		txtMartLocDel.setPromptText("e.g.: a-Ram");
		txtMartDel = new TextField();
		txtMartDel.setPromptText("e.g.: Elias");
		txtMartDateDel = new TextField();
		txtMartDateDel.setPromptText("(MM/DD/YYYY)");

		// Buttons
		btDisInst = new Button("Insert");
		btDisInstMain = new Button("Return To Main");
		btDisUpd = new Button("Update");
		btDisUpdMain = new Button("Return To Main");
		btDisNavNext = new Button("Next >");
		btDisNavPrev = new Button("< Previous");
		btDisNavLoad = new Button("Load");
		btLocNavLoad = new Button("Load");
		btDatesNavPrev = new Button("< Previous");
		btDatesNavNext = new Button("Next >");
		btDisNavLoad.setPadding(new Insets(10, 10, 10, 10));
		btDisNavMain = new Button("Return To Main");
		btLocInst = new Button("Insert");
		btLocInstMain = new Button("Return To Main");
		btLocUpd = new Button("Update");
		btLocUpdMain = new Button("Return To Main");
		btMartInst = new Button("Insert");
		btMartInstMain = new Button("Return To Main");
		btMartClear = new Button("Clear");
		btDisLocNavNext = new Button("Next Location >");
		btDisNavLocPrev = new Button("< Previous Location");
		btLocNavMain = new Button("Return To Main");
		btLocSeaMain = new Button("Return To Main");
		btMartSea = new Button("Search");
		btMartSeaMain = new Button("Return To Main");
		btMartUpd = new Button("Update");
		btMartCheckUpd = new Button("Check");
		btMartUpdMain = new Button("Return To Main");
		btMartCheckDel = new Button("Check");
		btMartDel = new Button("Delete");
		btMartDelMain = new Button("Return To Main");
		btDisChoUpd = new Button("Update");
		btDisChoRen = new Button("Rename");
		btDisChoMain = new Button("Return To Main");

		// TextArea
		txtAreaMain = new TextArea();
		txtAreaMain.setPrefHeight(350);
		txtAreaMain.setMaxWidth(700);
		txtAreaMain.setVisible(false);
		txtAreaMain.setEditable(false);
		txtAreaMain.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		txtAreaDisNavigation = new TextArea();
		txtAreaDisNavigation.setPrefHeight(350);
		txtAreaDisNavigation.setMaxWidth(700);
		txtAreaDisNavigation.setEditable(false);
		txtAreaDisNavigation.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		txtAreaLocSearch = new TextArea();
		txtAreaLocSearch.setPrefHeight(350);
		txtAreaLocSearch.setMaxWidth(700);
		txtAreaLocSearch.setEditable(false);
		txtAreaLocSearch.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		txtAreaMartSearch = new TextArea();
		txtAreaMartSearch.setPrefHeight(350);
		txtAreaMartSearch.setMaxWidth(700);
		txtAreaMartSearch.setEditable(false);
		txtAreaMartSearch.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		txtAreaMartDelete = new TextArea();
		txtAreaMartDelete.setPrefHeight(350);
		txtAreaMartDelete.setMaxWidth(700);
		txtAreaMartDelete.setEditable(false);
		txtAreaMartDelete.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		txtAreaMartUpd = new TextArea();
		txtAreaMartUpd.setPrefHeight(350);
		txtAreaMartUpd.setMaxWidth(700);
		txtAreaMartUpd.setEditable(false);
		txtAreaMartUpd.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		txtAreaDisNav = new TextArea();
		txtAreaDisNav.setPrefHeight(500);
		txtAreaDisNav.setMaxWidth(700);
		txtAreaDisNav.setEditable(false);
		txtAreaDisNav.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));

		// FileChooser
		fChooser = new FileChooser();

		// RadioButtons
		group = new ToggleGroup();
		rbMale = new RadioButton("Male");
		rbFemale = new RadioButton("Female");
		rbMale.setToggleGroup(group);
		rbFemale.setToggleGroup(group);
		rbUnknown = new RadioButton("Unknown");
		rbUnknown.setToggleGroup(group);

		// Combo Box
		disCmBox = new ComboBox<String>();
		disCmBox.getItems().add("-");

		locCmBox = new ComboBox<String>();
		locCmBox.getItems().add("-");

		martDateCmBox = new ComboBox<String>();
		martDateCmBox.getItems().add("-");

		// ArrayLists
		disNames = new ArrayList<>();
		locNames = new ArrayList<>();
		datesNames = new ArrayList<>();

		// Date Picker
		datePicker = new DatePicker();

		// TableView
		tableViewMartyrSearch = new TableView<>();
		tableViewMartyrSearch.setMaxWidth(910);
		tableViewMartyrSearch.setPrefHeight(350);

		tableViewDatesNavigation = new TableView<>();
		tableViewDatesNavigation.setMaxWidth(900);
		tableViewDatesNavigation.setPrefHeight(350);

		// Event handler for the MenuItems
		openItem.setOnAction(e -> readFile(primaryStage));
		disInsert.setOnAction(e -> insertDisScene(primaryStage));
		disUpdate.setOnAction(e -> updateDisScene(primaryStage));
		disDelete.setOnAction(e -> deleteDisScene(primaryStage));
		disNavigate.setOnAction(e -> navigateDisScene(primaryStage));
		disWrFile.setOnAction(e -> writeFileDisScene(primaryStage));
		locInsert.setOnAction(e -> insertLocScene(primaryStage));
		locUpdate.setOnAction(e -> updateLocScene(primaryStage));
		locDelete.setOnAction(e -> deleteLocScene(primaryStage));
		locNavigate.setOnAction(e -> navigateLocScene(primaryStage));
		locSearch.setOnAction(e -> navigateDateScene(primaryStage));
		martInsert.setOnAction(e -> insertMartScene(primaryStage));
		martUpdate.setOnAction(e -> updateMartScene(primaryStage));
		martDelete.setOnAction(e -> deleteMartScene(primaryStage));
		martSearch.setOnAction(e -> searchMartScene(primaryStage));

		// Main scene
		vBoxMain.getChildren().addAll(lblMainInst, txtAreaMain, lblMainInfo);
		bdPane.setTop(menuBar);
		bdPane.setCenter(vBoxMain);
		// Adding the panes on the scenes
		sceneMain = new Scene(bdPane, 1100, 800);
		primaryStage.setTitle("Main Screen Window");
		primaryStage.setScene(sceneMain);
		primaryStage.show();

		// InsertDisScene and DeleteDisScene and NumberOfMartyrsByDateScene
		hBoxInstDis.getChildren().addAll(lblDisInst, txtFieldDisInst);
		vBoxInstDis.getChildren().addAll(hBoxInstDis, lblDisInstInfo, btDisInst, btDisInstMain);

		// ChooseUpdDisScene
		hBoxChoUpdDis.getChildren().addAll(btDisChoUpd, btDisChoRen);
		vBoxChoUpdDis.getChildren().addAll(lblDisUpdChoInfo, hBoxChoUpdDis, btDisChoMain);

		// UpdateDisScene
		hBoxUpdDis.getChildren().addAll(lblDisUpdOld, disCmBox);
		hBoxUpdDis2.getChildren().addAll(lblDisUpdNew, txtDisUpdNew);
		vBoxUpdDis.getChildren().addAll(hBoxUpdDis, hBoxUpdDis2, lblDisUpdInfo, btDisUpd, btDisUpdMain);

		// District Navigation Scene
		hBoxNavDis1.getChildren().addAll(lblDisNavInfo, btDisNavLoad);
		hBoxNavDis.getChildren().addAll(btDisNavPrev, btDisNavNext);
		vBoxNavDis.getChildren().addAll(hBoxNavDis1, hBoxNavDis, btDisNavMain);

		// LocationInstScene
		hBoxInstDisLoc.getChildren().addAll(lblLocDisInst);
		hBoxInstLoc.getChildren().addAll(lblLocInst, txtLocInst);
		vBoxInstLoc.getChildren().addAll(hBoxInstDisLoc, hBoxInstLoc, lblLocInstInfo, btLocInst, btLocInstMain);

		// UpdateLocScene
		gdPane.add(lblLocDisUpd, 0, 0);
		gdPane.add(disCmBox, 1, 0);
		gdPane.add(lblOldLocUpd, 0, 1);
		gdPane.add(locCmBox, 1, 1);
		gdPane.add(lblNewLocUpd, 0, 2);
		gdPane.add(txtNewLocUpd, 1, 2);
		vBoxUpdLoc.getChildren().addAll(gdPane, lblLocUpdInfo, btLocUpd, btLocUpdMain);

		// NavigateLocScene
		hBoxNavLoc.getChildren().addAll(btDisNavLocPrev, btDisLocNavNext);
		hBoxNavLoc2.getChildren().addAll(lblLocNavInfo, btLocNavLoad);
		vBoxNavLoc.getChildren().addAll(disCmBox, hBoxNavLoc2, hBoxNavLoc, btLocNavMain);

		// NavigationDatesScene
		hBoxSeaDisLoc.getChildren().addAll(lblLocDisSea, disCmBox);
		hBoxSeaLoc.getChildren().addAll(lblLocSea, locCmBox);
		hBoxDatesNav.getChildren().addAll(btDatesNavPrev, btDatesNavNext);
		vBoxSeaLoc.getChildren().addAll(hBoxSeaDisLoc, hBoxSeaLoc, lblLocSeaInfo, hBoxDatesNav, txtAreaLocSearch,
				tableViewDatesNavigation, btLocSeaMain);

		// InsertMartScene
		hBoxInstMart.getChildren().addAll(btMartInst, btMartClear);
		hBox1.getChildren().addAll(rbMale, rbFemale, rbUnknown);
		gdPane1.add(lblMartName, 0, 0);
		gdPane1.add(txtMartName, 1, 0);
		gdPane1.add(lblMartDate, 0, 1);
		gdPane1.add(datePicker, 1, 1);
		gdPane1.add(lblMartAge, 0, 2);
		gdPane1.add(txtMartAge, 1, 2);
		gdPane1.add(lblMartDis, 0, 3);
		gdPane1.add(disCmBox, 1, 3);
		gdPane1.add(lblMartLoc, 0, 4);
		gdPane1.add(locCmBox, 1, 4);
		gdPane1.add(lblMartGender, 0, 5);
		gdPane1.add(hBox1, 1, 5);
		vBoxInstMart.getChildren().addAll(gdPane1, lblMartInstInfo, hBoxInstMart, btMartInstMain);

		// UpdateMartScene
		gdPaneMartUpd.add(lblMartDisUpd, 0, 0);
		gdPaneMartUpd.add(disCmBox, 1, 0);
		gdPaneMartUpd.add(lblMartLocUpd, 0, 1);
		gdPaneMartUpd.add(locCmBox, 1, 1);
		gdPaneMartUpd.add(lblMartDateUpd, 0, 2);
		gdPaneMartUpd.add(datePicker, 1, 2);
		gdPaneMartUpd.add(lblOldMartUpd, 0, 3);
		gdPaneMartUpd.add(txtOldMartUpd, 1, 3);
		gdPaneMartUpd.add(btMartUpd, 3, 3);
		gdPaneMartUpd.add(btMartCheckUpd, 2, 3);
		vBoxUpdMart.getChildren().addAll(gdPaneMartUpd, lblMartUpdInfo, txtAreaMartUpd, btMartUpdMain);

		// DeleteMartScene
		gdPaneMartDel.add(lblMartDisDel, 0, 0);
		gdPaneMartDel.add(disCmBox, 1, 0);
		gdPaneMartDel.add(lblMartLocDel, 0, 1);
		gdPaneMartDel.add(locCmBox, 1, 1);
		gdPaneMartDel.add(lblMartDateDel, 0, 2);
		gdPaneMartDel.add(datePicker, 1, 2);
		gdPaneMartDel.add(lblMartDel, 0, 3);
		gdPaneMartDel.add(txtMartDel, 1, 3);
		gdPaneMartDel.add(btMartDel, 3, 3);
		gdPaneMartDel.add(btMartCheckDel, 2, 3);
		vBoxDelMart.getChildren().addAll(gdPaneMartDel, lblMartDelInfo, txtAreaMartDelete, btMartDelMain);

		// SearchMartScene
//		gdPaneMartSea.add(lblMartDisSea, 0, 0);
//		gdPaneMartSea.add(disCmBox, 1, 0);
//		gdPaneMartSea.add(lblMartLocSea, 0, 1);
//		gdPaneMartSea.add(txtMartLocSea, 1, 1);
//		gdPaneMartSea.add(lblMartLocDateSea, 0, 2);
//		gdPaneMartSea.add(datePicker, 1, 2);
		gdPaneMartSea.add(lblMartSea, 0, 0);
		gdPaneMartSea.add(txtMartSea, 1, 0);
		gdPaneMartSea.add(btMartSea, 2, 0);
		vBoxSeaMart.getChildren().addAll(gdPaneMartSea, lblMartSeaInfo, tableViewMartyrSearch, btMartSeaMain);
	}

	// Method to read from a file
	private void readFile(Stage stage) {
		f = fChooser.showOpenDialog(stage);
		txtAreaMain.setText("");
		// Checks if the file was null
		if (f != null) {
			// Informing the user of the file name that was chosen and any error while
			// reading
			lblMainInst.setText("You opened this file: " + f.getName() + "\nReading from file warnings:");
			txtAreaMain.setVisible(true);
			lblMainInfo.setVisible(true);

			// try-catch block to handle any possible exception that might occurs
			try (Scanner read = new Scanner(f)) {
				// Skip the first line
				read.nextLine();
				// Keep reading from the file while it has content
				while (read.hasNextLine()) {
					String s = read.nextLine();
					// Split the line by ","
					String[] line = s.split(",");
					try {
						// If the format of the line was wrong
						if (line.length != 6)
							throw new IndexOutOfBoundsException("Incorrect inputs check the format!\n");
						// The first entry represents the name
						String name = line[0];
						if (containsNumeric(name)) {
							throw new InputMismatchException(name + ": name must only be String not a number");
						}

						// The second entry represents the event
						String date = line[1];
						byte age;

						// The third entry represents the age
						if (line[2].isEmpty()) {
							age = -1;
							txtAreaMain.appendText(name + " doesn't have an age.\n");
						} else {
							// Checks if the age was a digit or not
							if (isNumeric(line[2]))
								age = Byte.parseByte(line[2]);
							else {
								age = -1;
								txtAreaMain.appendText(name + " has an invalid age.\n");
							}
						}
						// The forth entry represents the location
						String location = line[3];
						if (containsNumeric(location)) {
							throw new InputMismatchException(name + ": location must only be String not a number");
						}

						// The fifth entry represents the district
						String district = line[4];
						if (containsNumeric(district)) {
							throw new InputMismatchException(name + ": district must only be String not a number");
						}

						if (!CorrectDate(date, lblLocInstInfo)) {
							txtAreaMain.appendText(name + " has invalid date of death\n");
						}
						char gender = '?';

						// The sixth entry represents the gender
						if (line[5].equals("NA") || line[5].isEmpty())
							gender = 'N';
						else
							gender = line[5].charAt(0);

						if (gender != 'm' && gender != 'M' && gender != 'F' && gender != 'f' && gender != 'N')
							throw new InputMismatchException(name + ": Gender must only be M/m/F/f\n");

						// Insert district
						District dis = new District(district);
						BSTDistrictNode districtNode = districtTree.find(dis);
						// district or Null
						if (districtNode == null) {
							districtNode = new BSTDistrictNode(dis);
							districtTree.insert(dis, lblDisInstInfo);
							disCmBox.getItems().add(district);
							districtNode.setHead(dis.getLocationTree());
						}
						disNames.add(district);

						// Get the reference to the locationTree of the district
						BSTLocation locationTree = districtNode.getHead();
						if (locationTree == null) {
							locationTree = new BSTLocation();
							districtNode.setHead(locationTree);
						}

						// Insert location
						Location loc = new Location(location);
						BSTLocationNode locationNode = locationTree.find(loc);
						if (locationNode == null) {
							locationNode = new BSTLocationNode(loc);
							locationTree.insert(loc, lblLocInstInfo);
							locCmBox.getItems().add(location);
							locationNode.setHead(loc.getMartyrTree());
						}
						locNames.add(location);

						// Get the reference to the martyrDateTree of the location
						BSTMartyrDate martyrDateTree = locationNode.getHead();
						if (martyrDateTree == null) {
							martyrDateTree = new BSTMartyrDate();
							locationNode.setHead(martyrDateTree);
						}

						// Insert martyr date
						MartyrDate martDate = new MartyrDate(date);
						BSTMartyrDateNode martDateNode = martyrDateTree.find(martDate);
						if (martDateNode == null) {
							martDateNode = new BSTMartyrDateNode(martDate);
							martyrDateTree.insert(martDate, lblDisInstInfo);
							martDateCmBox.getItems().add(date);
							martDateNode.setHead(martDate.getMartyrList());
						}
						datesNames.add(date);

						MartyrLinkedList martyrList = martDateNode.getHead();
						if (martyrList == null) {
							martyrList = new MartyrLinkedList(); // Create a new MartyrLinkedList
							martDateNode.setHead(martyrList); // Assign it to the BSTMartyrDateNode
						}

						// Insert martyr
						Martyr martyr = new Martyr(name, date, age, location, district, gender);
						MartyrNode martyrNode = new MartyrNode(martyr);
						martyrList.insertMartyrSorted(martyrNode, txtAreaMain, lblLocUpdInfo);

					}
					// Catch blocks to handle exceptions
					catch (InputMismatchException e1) {
						e1.printStackTrace();
						txtAreaMain.appendText(e1.getMessage());
					} catch (IndexOutOfBoundsException e1) {
						e1.printStackTrace();
						txtAreaMain.appendText(e1.getMessage());
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
						txtAreaMain.appendText(e1.getMessage());
					} catch (Exception e1) {
						e1.printStackTrace();
						txtAreaMain.appendText(e1.getMessage());
					}
				}
			}
			// Catch blocks to handle exceptions and organize nodes
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
				lblMainInst.setText(e1.getMessage());
				txtAreaMain.setVisible(false);
				lblMainInfo.setVisible(false);
			} catch (NoSuchElementException e1) {
				e1.printStackTrace();
				lblMainInst.setText(e1.getMessage());
				txtAreaMain.setVisible(false);
				lblMainInfo.setVisible(false);
			} catch (Exception e1) {
				e1.printStackTrace();
				lblMainInst.setText(e1.getMessage());
				txtAreaMain.setVisible(false);
				lblMainInfo.setVisible(false);
			}	
			sortComboBoxAlphabetically(disCmBox);
			sortComboBoxAlphabetically(locCmBox);
			sortComboBoxAlphabetically(martDateCmBox);

		}
	}

	// Method to print districts, locations, martyr dates, and martyrs
	private void printDistrictsLocationsMartyrs() {
		System.out.println("Districts, Locations, Martyr Dates, and Martyrs:");
		printDistrictsLocationsMartyrs(districtTree.getRoot());
	}

	// Helper method to print districts, locations, martyr dates, and martyrs
	// recursively
	private void printDistrictsLocationsMartyrs(BSTDistrictNode node) {
		if (node != null) {
			System.out.println("District: " + ((District) node.getElement()).getName());
			printLocationsMartyrDates(node.getHead());
			printDistrictsLocationsMartyrs(node.getLeft());
			printDistrictsLocationsMartyrs(node.getRight());
		}
	}

	// Helper method to print locations and martyr dates
	private void printLocationsMartyrDates(BSTLocation locationTree) {
		if (locationTree != null) {
			printLocationsMartyrDates(locationTree.getRoot());
		}
	}

	// Helper method to print locations and martyr dates recursively
	private void printLocationsMartyrDates(BSTLocationNode locationNode) {
		if (locationNode != null) {
			System.out.println("\tLocation: " + ((Location) locationNode.getElement()).getName());
			printMartyrDates(locationNode.getHead());
			printLocationsMartyrDates(locationNode.getLeft());
			printLocationsMartyrDates(locationNode.getRight());
		}
	}

	// Helper method to print martyr dates and martyrs
	private void printMartyrDates(BSTMartyrDate martyrDateTree) {
		if (martyrDateTree != null) {
			printMartyrDates(martyrDateTree.getRoot());
		}
	}

	// Method to print martyr dates and martyrs recursively
	private void printMartyrDates(BSTMartyrDateNode node) {
		if (node != null) {
			System.out.println("\t\tMartyr Date: " + ((MartyrDate) node.getElement()).getDate());
			printMartyrs(node.getHead());
			printMartyrDates(node.getLeft());
			printMartyrDates(node.getRight());
		}
	}

	// Helper method to print martyrs
	private void printMartyrs(MartyrLinkedList martyrList) {
		if (martyrList != null) {
			MartyrNode current = martyrList.getFront();
			while (current != null) {
				System.out.println("\t\t\tMartyr: " + ((Martyr) current.getElement()).getName());
				current = current.getNext();
			}
		} else {
			System.out.println("\t\t\tNo martyrs found for this date.");
		}
	}

	// Method that inserts a district to the list
	private void insertDisScene(Stage primaryStage) {
		clear();
		if (bdPane.getCenter() != vBoxInstDis)
			bdPane.setCenter(vBoxInstDis);

		if (hBoxInstDis.getChildren().contains(disCmBox) && !hBoxInstDis.getChildren().contains(txtFieldDisInst)) {
			hBoxInstDis.getChildren().remove(disCmBox);
			hBoxInstDis.getChildren().add(txtFieldDisInst);
		} else if (!hBoxInstDis.getChildren().contains(txtFieldDisInst)) {
			if (hBoxInstDis.getChildren().contains(disCmBox))
				hBoxInstDis.getChildren().remove(disCmBox);
			hBoxInstDis.getChildren().add(txtFieldDisInst);
		} else if (hBoxInstDis.getChildren().contains(disCmBox)) {
			hBoxInstDis.getChildren().remove(disCmBox);
			if (!hBoxInstDis.getChildren().contains(txtFieldDisInst))
				hBoxInstDis.getChildren().add(txtFieldDisInst);
		}

		// Organize the nodes on the scene
		lblDisInst.setText("District Name: ");
		lblDisInstInfo.setText("");
		txtFieldDisInst.clear();
		txtFieldDisInst.setPromptText("e.g.: Al-Quds");
		btDisInst.setText("Insert");
		lblDisInstInfo.setVisible(false);

		// Event handler for btDisInstMain button
		btDisInstMain.setOnAction(e -> returnMain(primaryStage));

		// Event handler for btDisInst button
		btDisInst.setOnAction(e -> {
			// Check if the textField is empty or not
			if (!txtFieldDisInst.getText().isEmpty()) {
				if (!containsNumeric(txtFieldDisInst.getText())) {
					// Insert district
					District dis = new District(txtFieldDisInst.getText());
					BSTDistrictNode districtNode = districtTree.find(dis);
					if (districtNode == null) {
						districtNode = new BSTDistrictNode(dis);
						if (districtTree.insert(dis, lblDisInstInfo)) {
							showAlert(Alert.AlertType.INFORMATION, "Insertation Success!",
									"District: " + dis.getName() + " has been inserted successfully!");
						} else
							showAlert(Alert.AlertType.ERROR, "Insertation Failed!",
									"District: " + dis.getName() + " has not been inserted!");
						disCmBox.getItems().add(txtFieldDisInst.getText());
						sortComboBoxAlphabetically(disCmBox);
						lblDisInstInfo.setVisible(true);
						districtNode.setHead(dis.getLocationTree());
					} else { // Notify the user that district exist from before
						lblDisInstInfo.setVisible(true);
						lblDisInstInfo.setText("Error: " + txtFieldDisInst.getText() + " district already exists!");
						showAlert(Alert.AlertType.ERROR, "District Already Exists",
								"Error: " + txtFieldDisInst.getText() + " district already exists!");
					}
				} else {
					lblDisInstInfo.setVisible(true);
					lblDisInstInfo.setText("Error: district name must be a string only!");
					showAlert(Alert.AlertType.ERROR, "Invalid District Name",
							"Error: district name must be a string only!");
				}
			} else { // Notify the user that the district is empty
				lblDisInstInfo.setVisible(true);
				lblDisInstInfo.setText("Error: Enter a district name first!");
				showAlert(Alert.AlertType.ERROR, "Empty District Name", "Error: Enter a district name first!");
			}

		});

		primaryStage.setTitle("Insert District");
		primaryStage.show();
	}

	private void updateDisScene(Stage primaryStage) {
		success = false;
		if (bdPane.getCenter() != vBoxUpdDis) {
			bdPane.setCenter(vBoxUpdDis);
		}

		if (!hBoxUpdDis.getChildren().contains(disCmBox)) {
			hBoxUpdDis.getChildren().add(disCmBox);
		}

		// Organize the nodes on the scene
		lblDisUpdInfo.setText("");
		txtDisUpdOld.clear();
		txtDisUpdNew.clear();
		lblDisUpdInfo.setVisible(false);
		txtDisUpdNew.setDisable(true);
		clear();
		btDisUpdMain.setOnAction(e -> returnMain(primaryStage));
		btDisChoMain.setOnAction(e -> returnMain(primaryStage));

		// Event handler for btDisChoRen button
		btDisUpd.setText("Rename");

		disCmBox.setOnAction(e2 -> {
			String oldName = disCmBox.getValue();
			if (oldName != null && !oldName.equals("-") && !oldName.trim().isEmpty()) {
				txtDisUpdNew.setDisable(false);
				txtDisUpdNew.clear();
			} else {
				txtDisUpdNew.setDisable(true);
			}
		});

		// Event handler for btDisUpd button with confirmation
		btDisUpd.setOnAction(e1 -> {
			String oldName = disCmBox.getValue();
			lblDisUpdInfo.setVisible(true);
			if (oldName != null && !oldName.equals("-") && !oldName.trim().isEmpty()) {
				String newName = txtDisUpdNew.getText();
				
				if(newName.isEmpty()) {
					showAlert(Alert.AlertType.ERROR, "Empty Location Name!",
							"Please enter a new name for " + oldName +" location!");
					return;
				}

				// Confirmation dialog before renaming
				Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
				confirmation.setTitle("Confirm Rename District");
				confirmation.setHeaderText("Are you sure you want to rename district?");
				confirmation.setContentText("This will rename '" + oldName + "' to '" + newName + "'");
				Optional<ButtonType> result = confirmation.showAndWait();

				if (result.isPresent() && result.get() == ButtonType.OK) {
					if (!containsNumeric(newName)) {
						success = districtTree.renameDistrict(oldName, newName, lblDisUpdInfo);
						if (success == true) {
							clear();
							// Update ComboBox items directly
							ObservableList<String> items = disCmBox.getItems();
							int index = items.indexOf(oldName);
							if (index != -1) {
								items.set(index, newName); // Replace old name with new name
								sortComboBoxAlphabetically(disCmBox); // Sort the ComboBox items alphabetically
							}
						}
					} else {
						lblDisUpdInfo.setText("Location name must be a string!");
						showAlert(Alert.AlertType.ERROR, "Invalid Location Name",
								"Error: location name must be a string only!");
					}
				}
			} else {
				lblDisUpdInfo.setText("Please choose a district first!");
				txtDisUpdNew.setDisable(true);
				showAlert(Alert.AlertType.ERROR, "Empty District Name", "Error: Enter a district name first!");
			}
		});

		primaryStage.setTitle("Update District");
		primaryStage.show();
	}

	private void deleteDisScene(Stage primaryStage) {
		// Organize the nodes on the scene
		lblDisInstInfo.setText("");
		txtFieldDisInst.clear();
		lblDisInst.setText("District Name: ");
		btDisInst.setText("Delete");
		lblDisInstInfo.setVisible(false);
		clear();

		if (bdPane.getCenter() != vBoxInstDis) {
			bdPane.setCenter(vBoxInstDis);
		}

		if (!hBoxInstDis.getChildren().contains(disCmBox) && hBoxInstDis.getChildren().contains(txtFieldDisInst)) {
			hBoxInstDis.getChildren().remove(txtFieldDisInst);
			hBoxInstDis.getChildren().add(disCmBox);
		} else if (!hBoxInstDis.getChildren().contains(disCmBox)) {
			if (hBoxInstDis.getChildren().contains(txtFieldDisInst)) {
				hBoxInstDis.getChildren().remove(txtFieldDisInst);
			}
			hBoxInstDis.getChildren().add(disCmBox);
		} else if (hBoxInstDis.getChildren().contains(txtFieldDisInst)) {
			hBoxInstDis.getChildren().remove(txtFieldDisInst);
			if (!hBoxInstDis.getChildren().contains(disCmBox)) {
				hBoxInstDis.getChildren().add(disCmBox);
			}
		}

		btDisInstMain.setOnAction(e -> returnMain(primaryStage));

		// Event handler for btDisInst button with confirmation
		btDisInst.setOnAction(e -> {
			String disName = disCmBox.getValue();
			// Check if the textField is empty or not
			if (disName != null && !disName.isEmpty() && !disName.equals("-")) {
				// Confirmation dialog before deleting
				Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
				confirmation.setTitle("Confirm Delete District");
				confirmation.setHeaderText("Are you sure you want to delete district?");
				confirmation.setContentText("This will permanently delete '" + disName + "'");
				Optional<ButtonType> result = confirmation.showAndWait();

				if (result.isPresent() && result.get() == ButtonType.OK) {
					lblDisInstInfo.setVisible(true);
					districtTree.remove(disName, lblDisInstInfo);
					disCmBox.getItems().remove(disName); // Remove district name from ComboBox
				}
			} else { // Notify the user that the textField is empty
				lblDisInstInfo.setVisible(true);
				lblDisInstInfo.setText("Error: Enter a district name first!");
				showAlert(Alert.AlertType.ERROR, "Empty District Name", "Error: Enter a district name first!");
			}
		});

		primaryStage.setTitle("Delete District");
		primaryStage.show();
	}

	private void navigateDisScene(Stage primaryStage) {
		// Organize the nodes on the scene
		txtAreaDisNavigation.setText("");
		txtAreaDisNavigation.setVisible(true);
		lblDisNavInfo.setText("");
		lblDisNavInfo.setVisible(true); // Show the label
		clear();
		btDisNavMain.setOnAction(e -> returnMain(primaryStage));

		forwardStack = new LinkedListStack();
		LinkedListStack visitedStack = new LinkedListStack();

		if (bdPane.getCenter() != vBoxNavDis) {
			bdPane.setCenter(vBoxNavDis);
		}

		// Ensure the stack is initialized with districts in order
		districtTree.inOrderTraversal(districtTree.getRoot());
		forwardStack = districtTree.getMemoryStack();

		if (forwardStack.isEmpty()) {
			lblDisNavInfo.setText("There are no districts!");
			return;
		}

		// Reverse the districts in the forwardStack and push them onto visitedStack
		while (!forwardStack.isEmpty()) {
			visitedStack.push(forwardStack.pop());
		}

		// Peek the first district for display
		if (!visitedStack.isEmpty()) {
			current = (String) visitedStack.pop();
			lblDisNavInfo.setText("District: " + current + "\n\n" + "Number of martyrs: "
					+ districtTree.martyrCountInLocations(current));
		}

		// Event handler for btDisNavPrev button
		btDisNavPrev.setOnAction(e -> {
			lblDisNavInfo.setVisible(true);
			txtAreaDisNavigation.setText("");

			if (!forwardStack.isEmpty()) {
				visitedStack.push(current);
				current = (String) forwardStack.pop();
				lblDisNavInfo.setText("District: " + current + "\n\n" + "Number of martyrs: "
						+ districtTree.martyrCountInLocations(current));
			}
		});

		// Event handler for btDisNavNext button
		btDisNavNext.setOnAction(e -> {
			lblDisNavInfo.setVisible(true);
			txtAreaDisNavigation.setText("");

			if (!visitedStack.isEmpty()) {
				forwardStack.push(current);
				current = (String) visitedStack.pop();
				lblDisNavInfo.setText("District: " + current + "\n\n" + "Number of martyrs: "
						+ districtTree.martyrCountInLocations(current));
			}
		});

		// Event handler for load button
		btDisNavLoad.setOnAction(e5 -> {
			// Create a new stage to show the district statistics
			Stage stage = new Stage();
			VBox vBoxDis = new VBox(20);
			vBoxDis.setAlignment(Pos.CENTER);
			vBoxDis.setPadding(new Insets(10, 10, 10, 10));

			Label lbl = new Label();
			lbl.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
			lbl.setPadding(new Insets(10, 10, 30, 10));
			lbl.setStyle(
					"-fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 2;");
			lbl.setText(current);

			vBoxDis.getChildren().addAll(lbl, txtAreaDisNav);

			currentDistrict = districtTree.find(new District(current));

			if (currentDistrict != null) {
				districtTree.btLoadDisNavigation(currentDistrict, txtAreaDisNav);
			}

			Scene scene = new Scene(vBoxDis, 1100, 800);
			stage.setScene(scene);
			stage.show();
		});

		primaryStage.setTitle("Navigate District");
		primaryStage.show();
	}

	// Method that inserts a location
	private void insertLocScene(Stage primaryStage) {
		// Organize the nodes on the scene
		lblLocDisInst.setText("District Name: ");
		txtLocDisInst.clear();
		txtLocDisInst.setPromptText("e.g.: al-Quds");
		lblLocInst.setText("Location Name: ");
		lblLocInstInfo.setText("");
		txtLocInst.clear();
		txtLocInst.setPromptText("e.g.: a-Ram");
		txtLocInst.setDisable(true);
		btLocInst.setText("Insert");
		lblLocInstInfo.setVisible(false);
		clear();
		btLocInstMain.setOnAction(e -> returnMain(primaryStage));

		if (bdPane.getCenter() != vBoxInstLoc)
			bdPane.setCenter(vBoxInstLoc);

		if (!hBoxInstDisLoc.getChildren().contains(disCmBox))
			hBoxInstDisLoc.getChildren().add(disCmBox);

		if (hBoxInstLoc.getChildren().contains(locCmBox) && !hBoxInstLoc.getChildren().contains(txtLocInst)) {
			hBoxInstLoc.getChildren().remove(locCmBox);
			hBoxInstLoc.getChildren().add(txtLocInst);
		} else if (!hBoxInstLoc.getChildren().contains(txtLocInst)) {
			if (hBoxInstLoc.getChildren().contains(locCmBox))
				hBoxInstLoc.getChildren().remove(locCmBox);
			hBoxInstLoc.getChildren().add(txtLocInst);
		} else if (hBoxInstLoc.getChildren().contains(locCmBox)) {
			hBoxInstLoc.getChildren().remove(locCmBox);
			if (!hBoxInstLoc.getChildren().contains(txtLocInst))
				hBoxInstLoc.getChildren().add(txtLocInst);
		}

		disCmBox.setOnAction(e2 -> {
			String disName = disCmBox.getValue();
			if (disName != null && !disName.isEmpty() && !disName.equals("-")) {
				txtLocInst.setDisable(false);
			} else
				txtLocInst.setDisable(true);
		});
		// Event handler for btLocInst button
		btLocInst.setOnAction(e -> {
			String disName = disCmBox.getValue();
			if (disName != null && !disName.isEmpty() && !disName.equals("-")) {
				if (!containsNumeric(txtLocInst.getText())) {
					// Insert district
					District dis = new District(disName);

					// Check the existence of the district
					BSTDistrictNode districtNode = districtTree.find(dis);
					if (districtNode == null) {
						districtNode = new BSTDistrictNode(dis);
						lblLocInstInfo.setVisible(true);
						lblLocInstInfo.setText("This '" + txtLocDisInst.getText() + "' district doesn't exist!");
						return;
					}
					// Get the reference to the locationList of the district
					BSTLocation locationList = districtNode.getHead();

					// Check if the textField is empty or not
					if (!txtLocInst.getText().isEmpty()) {
						// Insert location
						Location loc = new Location(txtLocInst.getText());

						// Check the existence of the location
						BSTLocationNode locationNode = locationList.find(loc);
						if (locationNode == null) {
							locationNode = new BSTLocationNode(loc);
							lblLocInstInfo.setVisible(true);
							if (locationList.insert(loc, lblLocInstInfo)) {
								showAlert(Alert.AlertType.INFORMATION, "Insertation Success!",
										"Location: " + loc.getName() + " has been inserted successfully!");
							} else
								showAlert(Alert.AlertType.ERROR, "Insertation Failed!",
										"Location: " + loc.getName()  + " has not been inserted!");
						} else { // Notify the user that the location already exist
							lblLocInstInfo.setVisible(true);
							lblLocInstInfo.setText("Error! This location already exist in this district!");
							return;
						}
					} else { // Notify the user that the textField is empty
						lblLocInstInfo.setVisible(true);
						lblLocInstInfo.setText("Error: Enter a location name!");
					}
				} else { // Notify the user that the location name contains string
					lblLocInstInfo.setVisible(true);
					lblLocInstInfo.setText("Error: Location name must be a string!");
				}
			} else { // Notify the user that the textField is empty
				lblLocInstInfo.setVisible(true);
				txtLocInst.setDisable(true);
				lblLocInstInfo.setText("Error: Enter a district name first!");
			}

		});

		primaryStage.setTitle("Insert Location");
		primaryStage.show();
	}

	private void updateLocScene(Stage primaryStage) {
		// Organize the nodes on the scene
		lblLocDisUpd.setText("District Name: ");
		txtLocDisUpd.clear();
		txtLocDisUpd.setPromptText("e.g.: al-Quds");
		lblOldLocUpd.setText("Old Location Name: ");
		txtOldLocUpd.clear();
		txtOldLocUpd.setPromptText("e.g.: a-Ram");
		lblNewLocUpd.setText("New Location Name: ");
		txtNewLocUpd.clear();
		txtNewLocUpd.setPromptText("e.g.: Bidu");
		lblLocUpdInfo.setText("");
		btLocUpd.setText("Update");
		lblLocUpdInfo.setVisible(false);
		locCmBox.setDisable(true);
		txtNewLocUpd.setDisable(true);
		clear();
		btLocUpdMain.setOnAction(e -> returnMain(primaryStage));
		btDisChoMain.setOnAction(e -> returnMain(primaryStage));

		if (bdPane.getCenter() != vBoxUpdLoc) {
			bdPane.setCenter(vBoxUpdLoc);
		}

		if (!gdPane.getChildren().contains(disCmBox)) {
			gdPane.add(disCmBox, 1, 0);
		}

		if (!gdPane.getChildren().contains(locCmBox)) {
			gdPane.add(locCmBox, 1, 1);
		}

		primaryStage.setTitle("Rename Location");
		primaryStage.show();
		btLocUpd.setText("Rename");

		disCmBox.setOnAction(e2 -> {
			String disName = disCmBox.getValue();
			if (disName != null && !disName.isEmpty() && !disName.equals("-")) {
				locCmBox.setDisable(false);
				districtTree.insertLocationsToComboBox(disName, locCmBox, lblLocInstInfo);
			} else {
				locCmBox.setDisable(true);
				locCmBox.getItems().clear();
				lblLocInstInfo.setText("Error: Choose a district name first!");
			}
		});

		locCmBox.setOnAction(e2 -> {
			String locName = locCmBox.getValue();
			if (locName != null && !locName.isEmpty() && !locName.equals("-")) {
				txtNewLocUpd.setDisable(false);
				txtNewLocUpd.clear();
			} else {
				txtNewLocUpd.setDisable(true);
			}
		});

		// Event handler for btLocUpd button with confirmation
		btLocUpd.setOnAction(e1 -> {
			lblLocUpdInfo.setVisible(true);
			String disName = disCmBox.getValue();
			String locName = locCmBox.getValue();
			if (disName != null && locName != null && !disName.isEmpty() && !disName.equals("-") && !locName.isEmpty()
					&& !locName.equals("-")) {
				if (!txtNewLocUpd.getText().isEmpty()) {
					if (!containsNumeric(txtNewLocUpd.getText())) {
						// Confirmation dialog before renaming
						Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
						confirmation.setTitle("Confirm Rename Location");
						confirmation.setHeaderText("Are you sure you want to rename location?");
						confirmation.setContentText("This will rename '" + locName + "' in '" + disName + "' to '"
								+ txtNewLocUpd.getText() + "'");
						Optional<ButtonType> result = confirmation.showAndWait();

						if (result.isPresent() && result.get() == ButtonType.OK) {
							districtTree.renameLocation(disName, locName, txtNewLocUpd.getText(), lblLocUpdInfo);
							locName = "";
							locCmBox.getItems().remove(locName);
							districtTree.insertLocationsToComboBox(disName, locCmBox, lblLocInstInfo);
						}
					} else {
						lblLocUpdInfo.setText("Error: Location name can't contain integers!");
						showAlert(Alert.AlertType.ERROR, "Invalid Location Name",
								"Error: location name must be a string only!");
					}
				} else {
					lblLocUpdInfo.setText("Error: Enter a new location name for " + locName + "!");
					showAlert(Alert.AlertType.ERROR, "Enter Location Name",
							"Error: Enter a new location name for " + locName + "!");
				}

			} else if (disName == null || disName.equals("-") || disName.isEmpty()) {
				lblLocUpdInfo.setText("Error: Choose a district name!");
				showAlert(Alert.AlertType.ERROR, "Empty District Name", "Error: Enter a district name first!");
			} else if (locName == null || locName.equals("-") || locName.isEmpty()) {
				lblLocUpdInfo.setText("Error: Choose a location name!");
				showAlert(Alert.AlertType.ERROR, "Empty Location Name", "Error: Enter a location name first!");
			} else {
				lblLocUpdInfo.setText("Error: Choose both district and location names!");
				showAlert(Alert.AlertType.ERROR, "Empty District and Location Name",
						"Error: Enter a district and location name first!");
			}
		});

		primaryStage.setTitle("Update Location");
		primaryStage.show();
	}

	private void deleteLocScene(Stage primaryStage) {
		// Organize the nodes on the scene
		lblLocDisInst.setText("District Name: ");
		txtLocDisInst.clear();
		txtLocDisInst.setPromptText("e.g.: al-Quds");
		lblLocInst.setText("Location Name: ");
		lblLocInstInfo.setText("");
		txtLocInst.clear();
		txtLocInst.setPromptText("e.g.: a-Ram");
		btLocInst.setText("Delete");
		lblLocInstInfo.setVisible(false);
		locCmBox.setDisable(true);
		clear();
		btLocInstMain.setOnAction(e -> returnMain(primaryStage));

		if (bdPane.getCenter() != vBoxInstLoc) {
			bdPane.setCenter(vBoxInstLoc);
		}

		if (!hBoxInstDisLoc.getChildren().contains(disCmBox)) {
			hBoxInstDisLoc.getChildren().add(disCmBox);
		}

		if (!hBoxInstLoc.getChildren().contains(locCmBox) && hBoxInstLoc.getChildren().contains(txtLocInst)) {
			hBoxInstLoc.getChildren().add(locCmBox);
			hBoxInstLoc.getChildren().remove(txtLocInst);
		} else if (!hBoxInstLoc.getChildren().contains(locCmBox)) {
			if (hBoxInstLoc.getChildren().contains(txtLocInst))
				hBoxInstLoc.getChildren().remove(txtLocInst);
			hBoxInstLoc.getChildren().add(locCmBox);
		} else if (hBoxInstLoc.getChildren().contains(txtLocInst)) {
			hBoxInstLoc.getChildren().remove(txtLocInst);
			if (!hBoxInstLoc.getChildren().contains(locCmBox))
				hBoxInstLoc.getChildren().add(locCmBox);
		}

		disCmBox.setOnAction(e2 -> {
			String disName = disCmBox.getValue();
			if (disName != null && !disName.isEmpty() && !disName.equals("-")) {
				locCmBox.setDisable(false);
				districtTree.insertLocationsToComboBox(disName, locCmBox, lblLocInstInfo);
			} else {
				locCmBox.setDisable(true);
				locCmBox.getItems().clear();
				lblLocInstInfo.setText("Error: Choose a district name first!");
			}
		});

		// Event handler for btLocInst button with confirmation
		btLocInst.setOnAction(e -> {
			lblLocInstInfo.setVisible(true);
			String disName = disCmBox.getValue();
			String locName = locCmBox.getValue();
			if (disName != null && locName != null && !disName.isEmpty() && !disName.equals("-") && !locName.isEmpty()
					&& !locName.equals("-")) {
				// Confirmation dialog before deleting
				Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
				confirmation.setTitle("Confirm Delete Location");
				confirmation.setHeaderText("Are you sure you want to delete location?");
				confirmation.setContentText("This will permanently delete '" + locName + "' from '" + disName + "'");
				Optional<ButtonType> result = confirmation.showAndWait();

				if (result.isPresent() && result.get() == ButtonType.OK) {
					districtTree.deleteLocation(disName, locName, lblLocInstInfo);
					locCmBox.getItems().remove(locName);
				}
			} else if (disName == null || disName.equals("-")) {
				lblLocInstInfo.setText("Error: Choose a district name!");
				showAlert(Alert.AlertType.ERROR, "Empty District Name", "Error: Enter a district name first!");
			} else if (locName == null || locName.equals("-")) {
				lblLocInstInfo.setText("Error: Choose a location name!");
				showAlert(Alert.AlertType.ERROR, "Empty Location Name", "Error: Enter a location name first!");
			} else {
				lblLocInstInfo.setText("Error: Choose both district and location names!");
				showAlert(Alert.AlertType.ERROR, "Empty District and Location Name",
						"Error: Enter a district and location name first!");
			}
		});

		primaryStage.setTitle("Delete Location");
		primaryStage.show();
	}

	private void navigateLocScene(Stage primaryStage) {
		clear();
		lblLocNavInfo.setVisible(false);
		btLocNavLoad.setVisible(false);
		btLocNavMain.setOnAction(e -> returnMain(primaryStage));

		if (bdPane.getCenter() != vBoxNavLoc) {
			bdPane.setCenter(vBoxNavLoc);
		}

		if (!vBoxNavLoc.getChildren().contains(disCmBox)) {
			vBoxNavLoc.getChildren().clear();
			vBoxNavLoc.getChildren().addAll(disCmBox, hBoxNavLoc2, hBoxNavLoc, btLocNavMain);
		}

		disCmBox.setOnAction(e4 -> {
			String disName = disCmBox.getValue();
			if (disName != null && !disName.equals("-") && !disName.isEmpty()) {
				lblLocNavInfo.setVisible(true);
				// Find the chosen district
				BSTDistrictNode currentDistrict = districtTree.find(new District(disName));
				btLocNavLoad.setVisible(true);

				if (currentDistrict == null) {
					lblLocNavInfo.setVisible(true);
					lblLocNavInfo.setText("District not found!");
					btLocNavLoad.setVisible(false);
					return;
				}

				// Get the location tree for the chosen district
				BSTLocation locationTree = currentDistrict.getHead();
				currentLocation = locationTree.getRoot();

				if (locationTree == null || locationTree.getRoot() == null) {
					lblLocNavInfo.setVisible(true);
					lblLocNavInfo.setText("This district has no locations!");
					btLocNavLoad.setVisible(false);
					return;
				}

				btLocNavLoad.setOnAction(e -> {
					lblLocNavInfo.setVisible(true);
					Stage stage = new Stage();
					VBox vBoxDis = new VBox(20);
					vBoxDis.setAlignment(Pos.CENTER);
					vBoxDis.setPadding(new Insets(10, 10, 10, 10));

					Label lbl = new Label();
					lbl.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
					lbl.setPadding(new Insets(10, 10, 30, 10));
					lbl.setStyle(
							"-fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 2;");
					lbl.setText(((Location) currentLocation.getElement()).getName());

					vBoxDis.getChildren().addAll(lbl, txtAreaDisNav);

					if (currentLocation != null) {
						districtTree.btLoadLocNavigation(currentLocation, txtAreaDisNav);
					}

					Scene scene = new Scene(vBoxDis, 1100, 800);
					stage.setScene(scene);
					stage.show();
				});

				lblLocNavInfo.setText("Location: " + ((Location) currentLocation.getElement()).getName()
						+ "\n\nThe earliest date that has martyrs: "
						+ locationTree.findEarliestDateWithMartyrs(currentLocation)
						+ "\n\nThe latest date that has martyrs: "
						+ locationTree.findLatestDateWithMartyrs(currentLocation)
						+ "\n\nThe date with maximum number is: "
						+ locationTree.findDateWithMaxMartyrs(currentLocation));

				// Event handler for btDisLocNavNext button (using locationTree)
				btDisLocNavNext.setOnAction(e -> {
					lblLocNavInfo.setVisible(true);
					if (currentLocation != null) {
						BSTLocationNode nextLocation = locationTree.getNextLocationInDistrict(locationTree.getRoot(),
								currentLocation);
						if (nextLocation != null) {
							currentLocation = nextLocation;
							lblLocNavInfo.setText("Location: " + ((Location) currentLocation.getElement()).getName()
									+ "\n\nThe earliest date that has martyrs: "
									+ locationTree.findEarliestDateWithMartyrs(currentLocation)
									+ "\n\nThe latest date that has martyrs: "
									+ locationTree.findLatestDateWithMartyrs(currentLocation)
									+ "\n\nThe date with maximum number is: "
									+ locationTree.findDateWithMaxMartyrs(currentLocation));
						}
					} else
						return;
				});

				// Event handler for btDisNavLocPrev button (using locationTree)
				btDisNavLocPrev.setOnAction(e -> {
					lblLocNavInfo.setVisible(true);
					if (currentLocation != null) {
						BSTLocationNode prevLocation = locationTree.getPrevLocationInDistrict(locationTree.getRoot(),
								currentLocation);
						if (prevLocation != null) {
							currentLocation = prevLocation;
							lblLocNavInfo.setText("Location: " + ((Location) currentLocation.getElement()).getName()
									+ "\n\nThe earliest date that has martyrs: "
									+ locationTree.findEarliestDateWithMartyrs(currentLocation)
									+ "\n\nThe latest date that has martyrs: "
									+ locationTree.findLatestDateWithMartyrs(currentLocation)
									+ "\n\nThe date with maximum number is: "
									+ locationTree.findDateWithMaxMartyrs(currentLocation));
						}
					} else
						return;
				});

			} else {
				lblLocNavInfo.setVisible(true);
				lblLocNavInfo.setText("Error: Please choose a district first!");
				btLocNavLoad.setVisible(false);
				currentLocation = null;
				return;
			}

		});

		primaryStage.setTitle("Navigate Locations");
		primaryStage.show();
	}

	private void navigateDateScene(Stage primaryStage) {
		// Organize the nodes on the scene
		txtAreaLocSearch.setText("");
		txtAreaLocSearch.setVisible(true);
		lblLocSeaInfo.setText("");
		lblLocSeaInfo.setVisible(false); // Show the label
		locCmBox.setDisable(true);
		clear();
		btLocSeaMain.setOnAction(e -> returnMain(primaryStage));

		if (bdPane.getCenter() != vBoxSeaLoc) {
			bdPane.setCenter(vBoxSeaLoc);
		}

		if (!hBoxSeaDisLoc.getChildren().contains(disCmBox)) {
			hBoxSeaDisLoc.getChildren().add(disCmBox);
		}

		if (!hBoxSeaLoc.getChildren().contains(locCmBox)) {
			hBoxSeaLoc.getChildren().clear();
			hBoxSeaLoc.getChildren().addAll(lblLocSea, locCmBox);
		}

		forwardStackDates = new LinkedListStack();

		// Event handler for the district combo box
		disCmBox.setOnAction(e3 -> {
			lblLocSeaInfo.setVisible(false);
			String disName = disCmBox.getValue();

			if (disName == null || disName.isEmpty() || disName.equals("-")) {
				txtAreaLocSearch.setText("");
				tableViewDatesNavigation.getColumns().clear();
				lblLocSeaInfo.setVisible(true);
				lblLocSeaInfo.setText("Please choose a district!");
				locCmBox.setDisable(true);
				return;
			}
			locCmBox.setDisable(false);

			BSTDistrictNode disNode = districtTree.find(new District(disName));

			if (disNode == null) {
				lblLocSeaInfo.setText("The district doesn't exist!");
				return;
			}
			districtTree.insertLocationsToComboBox(disName, locCmBox, lblLocInstInfo);

			BSTLocation locationTree = disNode.getHead();

			// Event handler for the location combo box
			locCmBox.setOnAction(e4 -> {
				String locName = locCmBox.getValue();

				if (locName == null || locName.isEmpty() || locName.equals("-")) {
					txtAreaLocSearch.setText("");
					tableViewDatesNavigation.getColumns().clear();
					lblLocSeaInfo.setVisible(true);
					lblLocSeaInfo.setText("Please choose a location!");
					return;
				}

				BSTLocationNode locNode = locationTree.find(new Location(locName));

				if (locNode == null) {
					txtAreaLocSearch.setText("");
					tableViewDatesNavigation.getColumns().clear();
					lblLocSeaInfo.setVisible(true);
					lblLocSeaInfo.setText("The location doesn't exist!");
					return;
				}

				BSTMartyrDate datesTree = locNode.getHead();

				LinkedListStack visitedStack = new LinkedListStack();

				datesTree.inOrderTraversal(datesTree.getRoot());

				forwardStackDates = datesTree.getMemoryStack();

				if (forwardStackDates.isEmpty()) {
					lblLocSeaInfo.setVisible(true);
					lblLocSeaInfo.setText("There are no dates!");
					txtAreaLocSearch.setText("");
					return;
				}

				// Reverse the districts in the forwardStack and push them onto visitedStack
				while (!forwardStackDates.isEmpty()) {
					visitedStack.push(forwardStackDates.pop());
				}

				// Peek the first date for display
				if (!visitedStack.isEmpty()) {
					txtAreaLocSearch.setText("");
					lblLocSeaInfo.setText("");
					currentDate = (String) visitedStack.pop();

					BSTMartyrDateNode dateNode = datesTree.find(new MartyrDate(currentDate));
					MartyrLinkedList martyrList = null;

					if (dateNode != null) {
						martyrList = dateNode.getHead();
						martyrList.displayAllMartyrs(tableViewDatesNavigation);
					} else
						System.out.println("1663");

					if (currentDate != null)
						txtAreaLocSearch.setText("Date: " + currentDate + "\n\n" + "Average martyrs ages: "
								+ martyrList.getMartyrAgeAvg() + "\n\nThe youngest martyr: "
								+ martyrList.getYoungestMartyrName() + " ,Age: " + martyrList.getYoungestAge()
								+ "\n\nThe oldest martyr: " + martyrList.getOldestMartyrName() + " ,Age: "
								+ martyrList.getOlderAge());

					tempDateNavData = txtAreaLocSearch.getText();
				} else {
					lblLocSeaInfo.setVisible(true);
					lblLocSeaInfo.setText("No more previous dates available.");
					txtAreaLocSearch.setText(tempDateNavData);
				}

				// Event handler for btDisNavPrev button
				btDatesNavPrev.setOnAction(e -> {
					lblLocSeaInfo.setVisible(false);
					txtAreaLocSearch.setText("");

					if (!forwardStackDates.isEmpty()) {
						lblLocSeaInfo.setText("");
						visitedStack.push(currentDate);
						currentDate = (String) forwardStackDates.pop();

						BSTMartyrDateNode dateNode = datesTree.find(new MartyrDate(currentDate));
						MartyrLinkedList martyrList = null;

						if (dateNode != null) {
							martyrList = dateNode.getHead();
							martyrList.displayAllMartyrs(tableViewDatesNavigation);
						} else
							System.out.println("1688");

						if (currentDate != null)
							txtAreaLocSearch.setText("Date: " + currentDate + "\n\n" + "Average martyrs ages: "
									+ martyrList.getMartyrAgeAvg() + "\n\nThe youngest martyr: "
									+ martyrList.getYoungestMartyrName() + " ,Age: " + martyrList.getYoungestAge()
									+ "\n\nThe oldest martyr: " + martyrList.getOldestMartyrName() + " ,Age: "
									+ martyrList.getOlderAge());
						tempDateNavData = txtAreaLocSearch.getText();
					} else {
						// No more previous dates available
						lblLocSeaInfo.setVisible(true);
						lblLocSeaInfo.setText("No more previous dates available.");
						txtAreaLocSearch.setText(tempDateNavData);
					}
				});

				// Event handler for btDisNavNext button
				btDatesNavNext.setOnAction(e -> {
					lblLocSeaInfo.setVisible(false);
					txtAreaLocSearch.setText("");

					if (!visitedStack.isEmpty()) {
						lblLocSeaInfo.setText("");
						forwardStackDates.push(currentDate);
						currentDate = (String) visitedStack.pop();
						BSTMartyrDateNode dateNode = datesTree.find(new MartyrDate(currentDate));
						MartyrLinkedList martyrList = null;

						if (dateNode != null) {
							martyrList = dateNode.getHead();
							martyrList.displayAllMartyrs(tableViewDatesNavigation);
						} else
							System.out.println("1713");

						if (currentDate != null)
							txtAreaLocSearch.setText("Date: " + currentDate + "\n\n" + "Average martyrs ages: "
									+ martyrList.getMartyrAgeAvg() + "\n\nThe youngest martyr: "
									+ martyrList.getYoungestMartyrName() + " ,Age: " + martyrList.getYoungestAge()
									+ "\n\nThe oldest martyr: " + martyrList.getOldestMartyrName() + " ,Age: "
									+ martyrList.getOlderAge());

						tempDateNavData = txtAreaLocSearch.getText();
					} else {
						// No more next dates available
						lblLocSeaInfo.setVisible(true);
						lblLocSeaInfo.setText("No more next dates available.");
						txtAreaLocSearch.setText(tempDateNavData);
					}
				});

			});

		});

		primaryStage.setTitle("Navigate Date");
		primaryStage.show();
	}

	// Method to insert a new martyr to the list
	private void insertMartScene(Stage primaryStage) {
		// Organize the nodes on the scene
		clear();
		btMartInst.setText("Insert");
		locCmBox.setDisable(true);
		btMartInstMain.setOnAction(e -> returnMain(primaryStage));

		if (bdPane.getCenter() != vBoxInstMart)
			bdPane.setCenter(vBoxInstMart);

		gdPane1.getChildren().clear();
		gdPane1.add(lblMartName, 0, 0);
		gdPane1.add(txtMartName, 1, 0);
		gdPane1.add(lblMartDate, 0, 1);
		gdPane1.add(datePicker, 1, 1);
		gdPane1.add(lblMartAge, 0, 2);
		gdPane1.add(txtMartAge, 1, 2);
		gdPane1.add(lblMartDis, 0, 3);
		gdPane1.add(disCmBox, 1, 3);
		gdPane1.add(lblMartLoc, 0, 4);
		gdPane1.add(locCmBox, 1, 4);
		gdPane1.add(lblMartGender, 0, 5);
		gdPane1.add(hBox1, 1, 5);

		// Add event listener to district combo box
		disCmBox.setOnAction(e -> {
			String selectedDistrict = disCmBox.getValue();
			if (selectedDistrict != null && !selectedDistrict.trim().isEmpty() && !selectedDistrict.equals("-")) {
				// Populate location combo box
				districtTree.insertLocationsToComboBox(selectedDistrict, locCmBox, lblDisInst);
				locCmBox.setDisable(false);
			} else
				locCmBox.setDisable(true);
		});

		// Set action for insert button
		btMartInst.setOnAction(e -> {
			// try-catch block to handle any exception that might occurs
			try {
				String name, date, location = null, district = null;

				// If all fields were empty it will inform the user
				if (txtMartName.getText().trim().isEmpty() && txtMartAge.getText().isEmpty()
						&& location == null && district == null && txtMartDate.getText().isEmpty()) {
					lblMartInstInfo.setVisible(true);
					lblMartInstInfo.setText("Fileds are empty");
					showAlert(Alert.AlertType.ERROR, "Empty Fileds", "Error: Fileds are empty!");
					return;
				}
				// If the name was empty it will inform the user
				if (txtMartName.getText().trim().isEmpty()) {
					lblMartInstInfo.setVisible(true);
					lblMartInstInfo.setText("Name is empty");
					showAlert(Alert.AlertType.ERROR, "Empty Name", "Error: Enter a name first!");
					return;
				} else {
					name = txtMartName.getText();
				}

				LocalDate selectedDate = datePicker.getValue();
				if (selectedDate.getMonthValue() < 10 && selectedDate.getDayOfMonth() >= 10) {
					date = selectedDate.format(DateTimeFormatter.ofPattern("M/dd/yyyy"));
				} else if (selectedDate.getDayOfMonth() < 10 && selectedDate.getMonthValue() < 10) {
					date = selectedDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
				} else if (selectedDate.getDayOfMonth() < 10 && selectedDate.getMonthValue() >= 10) {
					date = selectedDate.format(DateTimeFormatter.ofPattern("MM/d/yyyy"));
				} else if (selectedDate.getDayOfMonth() >= 10 && selectedDate.getMonthValue() >= 10) {
					date = selectedDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
				} else
					date = "";

//	          date = datePicker.getValue().getMonth()+"/"+datePicker.getValue().getDayOfMonth()+"/"+datePicker.getValue().getYear();

				// If the date was empty it will inform the user
				if (date.isEmpty()) {
					lblMartInstInfo.setVisible(true);
					lblMartInstInfo.setText("Date is empty");
					showAlert(Alert.AlertType.ERROR, "Empty Date", "Error: Enter a date first!");
					return;
				}

				byte age;
				// If the age was empty it will inform the user
				if (txtMartAge.getText().trim().isEmpty()) {
					age = -1;
					lblMartInstInfo.setVisible(true);
					lblMartInstInfo.setText("Warning: Age is empty!");
					showAlert(Alert.AlertType.WARNING, "Empty Age", "Age is empty!");
				} else {
					age = Byte.parseByte(txtMartAge.getText());
					if (age < 0) {
						lblMartInstInfo.setVisible(true);
						lblMartInstInfo.setText("Age must be greater or equal to zero!");
						showAlert(Alert.AlertType.ERROR, "Wrong Age", "Age must be greater or equal to zero!");
						return;
					}
				}
				
				String disName = disCmBox.getValue();

				// If the location was empty it will inform the user
				if (disName == null || disName.trim().isEmpty() || disName.equals("-")) {
					lblMartInstInfo.setVisible(true);
					lblMartInstInfo.setText("District is empty");
					showAlert(Alert.AlertType.ERROR, "Empty District", "Error: Enter a district name first!");
					return;
				} else {
					district = disName;
				}

				String locName = locCmBox.getValue();

				// If the location was empty it will inform the user
				if (locName == null || locName.trim().isEmpty() || locName.equals("-")) {
					lblMartInstInfo.setVisible(true);
					lblMartInstInfo.setText("Location is empty");
					showAlert(Alert.AlertType.ERROR, "Empty Location", "Error: Enter a location name first!");
					return;
				} else {
					location = locName;
				}

				char gender = '?';

				if (rbMale.isSelected())
					gender = 'M';
				else if (rbFemale.isSelected())
					gender = 'F';
				else if (rbUnknown.isSelected())
					gender = 'N';

				// If all fields were entered correctly it will add the new martyr
				if (!name.isEmpty() && (age >= 0 || age == -1) && !location.isEmpty() && !district.isEmpty()
						&& !date.isEmpty()) {
					// If no gender was selected it will throw an exception
					if (gender != 'M' && gender != 'F' && gender != 'N') {
						lblMartInstInfo.setVisible(true);
						lblMartInstInfo.setText("Choose a gender!");
						showAlert(Alert.AlertType.ERROR, "Age not Chosen", "Error: Please choose an age first!");
						return;
					}

					// Insert district
					District dis = new District(district);
					BSTDistrictNode districtNode = districtTree.find(dis);
					// district or Null
					if (districtNode == null) {
						districtNode = new BSTDistrictNode(dis);
						districtTree.insert(dis, lblMartInstInfo);
						districtNode.setHead(dis.getLocationTree());
					}

					// Get the reference to the locationTree of the district
					BSTLocation locationTree = districtNode.getHead();
					if (locationTree == null) {
						locationTree = new BSTLocation();
						districtNode.setHead(locationTree);
					}

					// Insert location
					Location loc = new Location(location);
					BSTLocationNode locationNode = locationTree.find(loc);
					if (locationNode == null) {
						locationNode = new BSTLocationNode(loc);
						locationTree.insert(loc, lblMartInstInfo);
						locationNode.setHead(loc.getMartyrTree());
					}

					// Get the reference to the martyrDateTree of the location
					BSTMartyrDate martyrDateTree = locationNode.getHead();
					if (martyrDateTree == null) {
						martyrDateTree = new BSTMartyrDate();
						locationNode.setHead(martyrDateTree);
					}

					// Insert martyr date
					MartyrDate martDate = new MartyrDate(date);
					BSTMartyrDateNode martDateNode = martyrDateTree.find(martDate);
					if (martDateNode == null) {
						martDateNode = new BSTMartyrDateNode(martDate);
						martyrDateTree.insert(martDate, lblMartInstInfo);
						martDateNode.setHead(martDate.getMartyrList());
					}

					MartyrLinkedList martyrList = martDateNode.getHead();
					if (martyrList == null) {
						martyrList = new MartyrLinkedList(); // Create a new MartyrLinkedList
						martDateNode.setHead(martyrList); // Assign it to the BSTMartyrDateNode
					}

					// Insert martyr
					Martyr martyr = new Martyr(name, date, age, location, district, gender);
					if (!districtTree.searchMartyr(martyr, lblMartInstInfo)) {
						MartyrNode martyrNode = new MartyrNode(martyr);
						lblMartInstInfo.setVisible(true);
						if(martyrList.insertMartyrSorted(martyrNode, txtAreaMain, lblMartInstInfo))
							showAlert(Alert.AlertType.INFORMATION, "Insertation Success!",
								"Martyr: " + name + " has been inserted successfully!");
						else
							showAlert(Alert.AlertType.ERROR, "Insertation Failed!",
									"Martyr '" + name + "' does exist from before!");
					} else {
						lblMartInstInfo.setVisible(true);
						lblMartInstInfo.setText("This martyr: " + martyr.getName() + " already exists!");
						showAlert(Alert.AlertType.ERROR, "Martyr Exist", "This martyr: " + martyr.getName() + " already exists!!");
					}

				}
				// If any field was empty it will notify the user
				else {
					lblMartInstInfo.setVisible(true);
					if (name.isEmpty()) {
						lblMartInstInfo.setText("Name is empty");
						showAlert(Alert.AlertType.ERROR, "Empty Name", "Error: Enter a martyr name first!");
						return;
					}
					if (location.isEmpty()) {
						lblMartInstInfo.setText("Location is empty");
						showAlert(Alert.AlertType.ERROR, "Empty Location Name", "Error: Enter a location name first!");
						return;
					}
					if (district.isEmpty()) {
						lblMartInstInfo.setText("District is empty");
						showAlert(Alert.AlertType.ERROR, "Empty District Name", "Error: Enter a district name first!");
						return;
					}
					if (date.isEmpty()) {
						lblMartInstInfo.setText("Date is empty");
						showAlert(Alert.AlertType.ERROR, "Empty Date", "Error: Enter a date first!");
						return;
					}
					if (gender == '?') {
						lblMartInstInfo.setText("Gender is not chosen");
						showAlert(Alert.AlertType.ERROR, "Gender not chosen", "Error: choose a gender first!");
						return;
					}
				}
			}
			// Catch blocks to handle exceptions
			catch (InputMismatchException e1) {
				lblMartInstInfo.setVisible(true);
				lblMartInstInfo.setText(e1.getMessage());
			} catch (NumberFormatException e1) {
				lblMartInstInfo.setVisible(true);
				lblMartInstInfo.setText("Please an integer for the age not a string!");
				showAlert(Alert.AlertType.ERROR, "Wrong Fotmat", "Error: this field should contains only string not integer!");
			} catch (Exception e1) {
				lblMartInstInfo.setVisible(true);
				lblMartInstInfo.setText(e1.getMessage());
			}
		});

		btMartClear.setOnAction(e -> clear());

		primaryStage.setTitle("Insert Martyr");
		primaryStage.show();
	}

	// Method that updates a martyr information
	private void updateMartScene(Stage primaryStage) {
		// Organize the nodes on the scene
		clear();
		lblMartUpdInfo.setText("");
		txtMartDisUpd.clear();
		txtMartLocUpd.clear();
		txtOldMartUpd.clear();
		txtMartDateUpd.clear();
		txtAreaDisNavigation.setText("");
		txtAreaMartUpd.setText("");
		lblMartDateUpd.setVisible(true);
		txtMartDateUpd.setVisible(true);
		txtAreaMartUpd.setVisible(false);
		lblMartUpdInfo.setVisible(false);
		btMartUpd.setVisible(false);

		btMartUpdMain.setOnAction(e -> returnMain(primaryStage));

		if (bdPane.getCenter() != vBoxUpdMart)
			bdPane.setCenter(vBoxUpdMart);

		if (!gdPaneMartUpd.getChildren().contains(disCmBox))
			gdPaneMartUpd.add(disCmBox, 1, 0);

		if (!gdPaneMartUpd.getChildren().contains(locCmBox))
			gdPaneMartUpd.add(locCmBox, 1, 1);

		if (!gdPaneMartUpd.getChildren().contains(datePicker))
			gdPaneMartUpd.add(datePicker, 1, 2);

		// Add event listener to district combo box
		disCmBox.setOnAction(e -> {
			String selectedDistrict = disCmBox.getValue();
			if (selectedDistrict != null && !selectedDistrict.trim().isEmpty() && !selectedDistrict.equals("-")) {
				// Populate location combo box
				districtTree.insertLocationsToComboBox(selectedDistrict, locCmBox, lblDisInst);
				locCmBox.setDisable(false);
			} else
				locCmBox.setDisable(true);
		});

		// Event handler for btMartCheckUpd button
		btMartCheckUpd.setOnAction(e -> {
			txtAreaMartUpd.setText("");
			lblMartUpdInfo.setVisible(true);

			String disName = disCmBox.getValue();
			String locName = locCmBox.getValue();
			String date = "";

			// Check if the textFields are empty and notify the user
			if (disName == null || disName.isEmpty() || disName.equals("-")) {
				lblMartUpdInfo.setVisible(true);
				lblMartUpdInfo.setText("Please enter a district!");
				showAlert(Alert.AlertType.ERROR, "Empty District Name", "Error: Enter a district name first!");
				return;
			} else if (locName == null || locName.isEmpty() || locName.equals("-")) {
				lblMartUpdInfo.setVisible(true);
				lblMartUpdInfo.setText("Please enter a location!");
				showAlert(Alert.AlertType.ERROR, "Empty Location Name", "Error: Enter a location name first!");
				return;
			}

			LocalDate selectedDate = datePicker.getValue();
			if (selectedDate != null) {
				if (selectedDate.getMonthValue() < 10 && selectedDate.getDayOfMonth() >= 10) {
					date = selectedDate.format(DateTimeFormatter.ofPattern("M/dd/yyyy"));
				} else if (selectedDate.getDayOfMonth() < 10 && selectedDate.getMonthValue() < 10) {
					date = selectedDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
				} else if (selectedDate.getDayOfMonth() < 10 && selectedDate.getMonthValue() >= 10) {
					date = selectedDate.format(DateTimeFormatter.ofPattern("MM/d/yyyy"));
				} else if (selectedDate.getDayOfMonth() >= 10 && selectedDate.getMonthValue() >= 10) {
					date = selectedDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
				} else
					date = "";
			} else {
				lblMartDelInfo.setVisible(true);
				lblMartDelInfo.setText("Enter a date first!");
				showAlert(Alert.AlertType.ERROR, "Empty Date", "Error: Enter a date first!");
				return;
			}
			
			if (date == null || date.isEmpty()) {
				lblMartDelInfo.setVisible(true);
				lblMartDelInfo.setText("Enter a date first!");
				showAlert(Alert.AlertType.ERROR, "Empty Date", "Error: Enter a date first!");
				return;
			} else if (txtOldMartUpd.getText().isEmpty()) {
				lblMartUpdInfo.setText("Please enter a martyr name to update!");
				showAlert(Alert.AlertType.ERROR, "Empty Martyr Name", "Error: Enter a name first!");
				return;
			}

			// Check the existence of the district
			BSTDistrictNode districtNode = districtTree.find(new District(disName));
			if (districtNode == null) {
				lblMartUpdInfo.setVisible(true);
				lblMartUpdInfo.setText("The district is wrong!");
				showAlert(Alert.AlertType.ERROR, "Wrong District", "Error: The district is wrong or doesn't exist!");
				return;
			}
			BSTLocation locationList = districtNode.getHead();

			// Check the existence of the location
			BSTLocationNode locationNode = locationList.find(new Location(locName));
			if (locationNode == null) {
				lblMartUpdInfo.setVisible(true);
				lblMartUpdInfo.setText("The location is wrong!");
				showAlert(Alert.AlertType.ERROR, "Wrong Location", "Error: The location is wrong or doesn't exist!");
				return;
			}

			BSTMartyrDate martyrDateList = locationNode.getHead();

			// Check the existence of the location
			BSTMartyrDateNode martyrDateNode = martyrDateList.find(new MartyrDate(date));
			if (martyrDateNode == null) {
				lblMartUpdInfo.setVisible(true);
				lblMartUpdInfo.setText("The date is wrong or doesn't exist!");
				showAlert(Alert.AlertType.ERROR, "Wrong Date", "Error: The date is wrong or doesn't exist!");
				return;
			}

			MartyrLinkedList martyrList = martyrDateNode.getHead();
			
			if(txtOldMartUpd.getText().isEmpty()) {
				lblMartUpdInfo.setVisible(true);
				lblMartUpdInfo.setText("The name is empty!");
				showAlert(Alert.AlertType.ERROR, "Empty name", "Error: The name is empty!");
				return;
			}

			// Check the existence of the martyr with the count of them
			int result = martyrList.check(txtOldMartUpd.getText(), txtAreaMartUpd, lblMartUpdInfo);
			// If the check method returned 1 it will inform the user the the martyr has
			// been found and can be deleted
			if (result >= 1) {
				lblMartUpdInfo.setText(txtOldMartUpd.getText() + " has been found, press update to update him/her");
				// Organize the nodes on the scene
				lblMartUpdInfo.setVisible(true);
				txtAreaMartUpd.setVisible(false);
				btMartUpd.setVisible(true);
				btMartUpd.setOnAction(e1 -> {
					districtTree.returnMartyr(martyrList, txtOldMartUpd.getText(), txtMartName, txtMartDate, txtMartAge,
							txtMartLoc, txtMartDis, rbMale, rbFemale, rbUnknown);
					lblMartUpdInfo.setVisible(true);
					// Inform the user if the name field is empty
					if (txtOldMartUpd.getText().isEmpty()) {
						lblMartUpdInfo.setText("Name is empty!");
						showAlert(Alert.AlertType.ERROR, "Empty Name", "Error: Name is empty!");
					} else {
						// Update martyr information if the name isn't empty
						lblMartUpdInfo.setVisible(true);
						MartUpdButton(primaryStage, martyrList, districtNode);
					}
				});
			}
			// If the check method returned a number greater than 1 it will inform the user
			// that there's more than one martyr with the same name
//			else if (result > 1) {
//				// Organize the nodes on the scene
//				btMartUpd.setVisible(true);
//				lblMartDateUpd.setVisible(true);
//				txtMartDateUpd.setVisible(true);
//				btMartUpd.setOnAction(e1 -> {
//					districtTree.returnMartyr(martyrList, txtOldMartUpd.getText(), txtMartName, txtMartDate, txtMartAge,
//							txtMartLoc, txtMartDis, rbMale, rbFemale, rbUnknown);
//					lblMartUpdInfo.setVisible(true);
//					// Check if the textFields are empty
//					if (!txtOldMartUpd.getText().isEmpty() && !txtMartDateUpd.getText().isEmpty()) {
//						MartUpdButton(primaryStage, martyrList, districtNode);
//					} else { // Notify the user that the textFields are empty
//						if (txtOldMartUpd.getText().isEmpty()) {
//							lblMartUpdInfo.setText("Name is empty!");
//						} else if (txtMartDateUpd.getText().isEmpty()) {
//							lblMartUpdInfo.setText("You didn't enter the date of death!");
//						}
//					}
//				});
//			}
			// If the check method returned zero this means that there is no martyrs with
			// the same name in the list
			else if (result == 0) {
				txtAreaMartUpd.setVisible(false);
				lblMartUpdInfo.setVisible(true);
				btMartUpd.setVisible(false);
				lblMartUpdInfo.setText(txtOldMartUpd.getText() + " wasn't found!");
				showAlert(Alert.AlertType.ERROR, "Martyr doesn't exist",
						"Error: " + txtOldMartUpd.getText() + " wasn't found!!");
			}
		});

		primaryStage.setTitle("Update Martyr");
		primaryStage.show();
	}

	// Method that deletes a martyr
	private void deleteMartScene(Stage primaryStage) {
		// Organize the nodes on the scene
		clear();
		txtMartDisDel.clear();
		txtMartLocDel.clear();
		txtMartDel.clear();
		txtMartDateDel.clear();
		lblMartDelInfo.setText("");
		lblMartDelInfo.setVisible(false);
		lblMartDateDel.setVisible(true);
		txtMartDateDel.setVisible(true);
		btMartDel.setVisible(false);
		txtAreaMartDelete.setVisible(false);

		btMartDelMain.setOnAction(e -> returnMain(primaryStage));

		if (bdPane.getCenter() != vBoxDelMart)
			bdPane.setCenter(vBoxDelMart);

		if (!gdPaneMartDel.getChildren().contains(disCmBox))
			gdPaneMartDel.add(disCmBox, 1, 0);

		if (!gdPaneMartDel.getChildren().contains(locCmBox))
			gdPaneMartDel.add(locCmBox, 1, 1);

		if (!gdPaneMartDel.getChildren().contains(datePicker))
			gdPaneMartDel.add(datePicker, 1, 2);

		// Add event listener to district combo box
		disCmBox.setOnAction(e -> {
			String selectedDistrict = disCmBox.getValue();
			if (selectedDistrict != null && !selectedDistrict.trim().isEmpty() && !selectedDistrict.equals("-")) {
				// Populate location combo box
				districtTree.insertLocationsToComboBox(selectedDistrict, locCmBox, lblDisInst);
				locCmBox.setDisable(false);
			} else
				locCmBox.setDisable(true);
		});

		// Event handler for the check button in the delete scene to check the existence
		// of the martyr using Check method
		btMartCheckDel.setOnAction(e -> {
			txtAreaMartDelete.setText("");
			txtAreaMartDelete.setVisible(false);

			String disName = disCmBox.getValue();
			String locName = locCmBox.getValue();
			String date = "";

			if (disName == null || disName.isEmpty() || disName.equals("-")) {
				lblMartDelInfo.setVisible(true);
				lblMartDelInfo.setText("Enter a district first!");
				showAlert(Alert.AlertType.ERROR, "Empty District Name", "Error: Enter a district name first!");
				return;
			} else if (locName == null || locName.isEmpty() || locName.equals("-")) {
				lblMartDelInfo.setVisible(true);
				lblMartDelInfo.setText("Enter a location first!");
				showAlert(Alert.AlertType.ERROR, "Empty Location Name", "Error: Enter a location name first!");
				return;
			}

			LocalDate selectedDate = datePicker.getValue();
			if (selectedDate != null) {
				if (selectedDate.getMonthValue() < 10 && selectedDate.getDayOfMonth() >= 10) {
					date = selectedDate.format(DateTimeFormatter.ofPattern("M/dd/yyyy"));
				} else if (selectedDate.getDayOfMonth() < 10 && selectedDate.getMonthValue() < 10) {
					date = selectedDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
				} else if (selectedDate.getDayOfMonth() < 10 && selectedDate.getMonthValue() >= 10) {
					date = selectedDate.format(DateTimeFormatter.ofPattern("MM/d/yyyy"));
				} else if (selectedDate.getDayOfMonth() >= 10 && selectedDate.getMonthValue() >= 10) {
					date = selectedDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
				} else
					date = "";
			} else {
				lblMartDelInfo.setVisible(true);
				lblMartDelInfo.setText("Enter a date first!");
				showAlert(Alert.AlertType.ERROR, "Empty Date", "Error: Enter a date first!");
				return;
			}
			
			if (date == null || date.isEmpty()) {
				lblMartDelInfo.setVisible(true);
				lblMartDelInfo.setText("Enter a date first!");
				showAlert(Alert.AlertType.ERROR, "Empty Date", "Error: Enter a date first!");
				return;
			}

			// Check the existence of the district
			BSTDistrictNode districtNode = districtTree.find(new District(disName));
			if (districtNode == null) {
				lblMartDelInfo.setVisible(true);
				lblMartDelInfo.setText("The district is wrong!");
				showAlert(Alert.AlertType.ERROR, "Wrong District", "Error: The district is wrong or doesn't exist!");
				return;
			}
			BSTLocation locationList = districtNode.getHead();

			// Check the existence of the location
			BSTLocationNode locationNode = locationList.find(new Location(locName));
			if (locationNode == null) {
				lblMartDelInfo.setVisible(true);
				lblMartDelInfo.setText("The location is wrong!");
				showAlert(Alert.AlertType.ERROR, "Wrong Location", "Error: The location is wrong or doesn't exist!");
				return;
			}

			BSTMartyrDate martyrDateList = locationNode.getHead();

			// Check the existence of the location
			BSTMartyrDateNode martyrDateNode = martyrDateList.find(new MartyrDate(date));
			if (martyrDateNode == null) {
				lblMartDelInfo.setVisible(true);
				lblMartDelInfo.setText("The date is wrong or doesn't exist!");
				showAlert(Alert.AlertType.ERROR, "Wrong Date", "Error: The date is wrong or doesn't exist!");
				return;
			}

			MartyrLinkedList martyrList = martyrDateNode.getHead();
			
			if(txtMartDel.getText().isEmpty()) {
				lblMartDelInfo.setVisible(true);
				lblMartDelInfo.setText("The name is empty!");
				showAlert(Alert.AlertType.ERROR, "Empty name", "Error: The name is empty!");
				return;
			}
			
			int result = martyrList.check(txtMartDel.getText(), txtAreaMartDelete, lblMartDelInfo);

			// If the check method returned 1 (one martyr) it will inform the user the the
			// martyr has been found and can be deleted
			if (result >= 1) {
				lblMartDelInfo.setText(txtMartDel.getText() + " has been found press delete to delete him/her");
				lblMartDelInfo.setVisible(true);
				txtAreaMartDelete.setVisible(false);
				btMartDel.setVisible(true);

				btMartDel.setOnAction(e1 -> {
					lblMartDelInfo.setVisible(true);
					// If the name was empty it will inform the user
					if (txtMartDel.getText().isEmpty()) {
						lblMartDelInfo.setText("Name is empty!");
					} else {
						// If the name wasn't empty it will be deleted
						// Confirmation dialog for updating martyr information
						Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
						confirmation.setTitle("Confirm Delete Martyr");
						confirmation.setHeaderText("Are you sure you want to delete martyr ?");
						confirmation.setContentText(
								"This will delete '" + txtMartDel.getText() + "' information permenantly.");
						Optional<ButtonType> deleteResult = confirmation.showAndWait();

						if (deleteResult.isPresent() && deleteResult.get() == ButtonType.OK) {
							martyrList.deleteMartyr1(txtMartDel.getText(), lblMartDelInfo);
							btMartDel.setVisible(false);
						}
					}
				});
			}
//			 If the check method returned a number greater than 1 (more than one martyr)
//			 it will inform the user that there's more than one martyr with the same name
//				else if (result > 1) {
//					// Organize the nodes on the scene
//					txtAreaMartDelete.setVisible(true);
//					btMartDel.setVisible(true);
//					lblMartDateDel.setVisible(true);
//					txtMartDateDel.setVisible(true);
//			
//					// Event handler for the btMartDel button
//					btMartDel.setOnAction(e1 -> {
//						lblMartDelInfo.setVisible(true);
//						// Check if the textFields are empty
//						if (!txtMartDel.getText().isEmpty() && !txtMartDateDel.getText().isEmpty()) {
//							martyrList.deleteMartyrWithDate(txtMartDel.getText(), txtMartDateDel.getText(), lblMartDelInfo);
//			
//							// Organize the nodes on the scene
//							btMartDel.setVisible(false);
//							lblMartDateDel.setVisible(false);
//							txtMartDateDel.setVisible(false);
//							txtAreaMartDelete.setVisible(false);
//						} else {
//							if (txtMartDel.getText().isEmpty()) {
//								lblMartDelInfo.setText("Name is empty!");
//							} else if (txtMartDateDel.getText().isEmpty()) {
//								lblMartDelInfo.setText("You didn't enter the date of death!");
//							}
//						}
//					});
//				}
			// If the check method returned zero this means that there is no martyrs with
			// the same name in the list
			else if (result == 0) {
				// Organize the nodes on the scene
				txtAreaMartDelete.setVisible(false);
				lblMartDelInfo.setVisible(true);
				btMartDel.setVisible(false);
				lblMartDelInfo.setText("Error! Can't delete this martyr because s/he doesn't exist.");
				showAlert(Alert.AlertType.ERROR, "Martyr doesn't exist",
						"Error: " + txtOldMartUpd.getText() + " wasn't found!!");
			}

		});

		primaryStage.setTitle("Delete Martyr");
		primaryStage.show();
	}

	// Method that searches for martyr
	private void searchMartScene(Stage primaryStage) {
		// Organize the nodes on the scene
		clear();
		txtMartDisSea.setText("");
		txtMartLocSea.setText("");
		txtMartSea.setText("");
		btMartSeaMain.setOnAction(e -> returnMain(primaryStage));
		lblMartSeaInfo.setVisible(false);
		tableViewMartyrSearch.setVisible(false);

		if (bdPane.getCenter() != vBoxSeaMart)
			bdPane.setCenter(vBoxSeaMart);

		String disName = "";
		// Event handler for the btMartSea button
		btMartSea.setOnAction(e -> {
			lblMartSeaInfo.setText("");
			txtAreaMartSearch.setText("");
			String date = "";

			districtTree.searchMartyrByName(disName, txtMartLocSea.getText(), date, txtMartSea.getText(),
					tableViewMartyrSearch, lblMartSeaInfo);
		});

	}

	// Method that writes the district information on a file
	private void writeFileDisScene(Stage primaryStage) {
		// Organize the nodes on the scene
		lblDisInst.setText("File Name: ");
		lblDisInstInfo.setText("");
		txtFieldDisInst.clear();
		txtFieldDisInst.setPromptText("e.g.: Al-Quds");
		btDisInst.setText("Save");
		lblDisInstInfo.setVisible(false);
		btDisInstMain.setOnAction(e -> returnMain(primaryStage));

		if (bdPane.getCenter() != vBoxInstDis)
			bdPane.setCenter(vBoxInstDis);

		// Event handler for btDisInst button
		btDisInst.setOnAction(e -> {
			// Check if the textField is empty or not
			if (!txtFieldDisInst.getText().isEmpty()) {
				String fileName = txtFieldDisInst.getText().concat(".csv");

				// Check if the file already exists
				File file = new File(fileName);
				if (file.exists()) {
					// File exists, show confirmation dialog
					Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
					alert.setTitle("Confirmation");
					alert.setHeaderText("File already exists!");
					alert.setContentText("The file \"" + fileName + "\" already exists. Do you want to override it?");

					ButtonType yesButton = new ButtonType("Yes");
					ButtonType noButton = new ButtonType("No");

					alert.getButtonTypes().setAll(yesButton, noButton);

					alert.showAndWait().ifPresent(buttonType -> {
						if (buttonType == yesButton) {
							// User clicked Yes, override the file
							if (districtTree.writeOnFile(fileName)) {
								// File saved successfully, show confirmation
								showConfirmationAlert("File Saved",
										"The file \"" + fileName + "\" has been saved successfully!");
							}
						}
					});
				} else {
					// File does not exist, directly write to the file
					if (districtTree.writeOnFile(fileName)) {
						// File saved successfully, show confirmation
						showConfirmationAlert("File Saved",
								"The file \"" + fileName + "\" has been saved successfully!");
					}
				}
			} else { // Notify the user that the textField is empty
				lblDisInstInfo.setVisible(true);
				lblDisInstInfo.setText("Error: Enter a file name first!");
			}
		});

		primaryStage.setTitle("Write District On File");
		primaryStage.show();
	}

	// Method to show a confirmation alert
	private void showConfirmationAlert(String title, String message) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	// Method that checks if the date is in the correct format and valid
	private boolean CorrectDate(String date, Label lbl) {
		// If the date contains "-" and doesn't contain "/" it will return false
		if (date.contains("-") || !date.contains("/")) {
			lbl.setText("Check the date format it should be written (MM/DD/YYYY)");
			return false;
		}

		// If the date didn't contain 3 parts it will return false
		String[] d = date.split("/");
		if (d.length != 3) {
			lbl.setText("Check the date format it should be written (MM/DD/YYYY)");
			return false;
		}

		int year, month, day;
		try {
			day = Integer.parseInt(d[1]);
			month = Integer.parseInt(d[0]);
			year = Integer.parseInt(d[2]);
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			return false;
		} catch (Exception e) {
			return false;
		}

		// If the moth was anything except the numbers form 1-12 it will return false
		if (month < 1 || month > 12) {
			lbl.setText("The date is invalid, check the date format (MM/DD/YYYY)");
			return false;
		}

		int daysInMonth;
		// February
		if (month == 2) {
			if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
				// Leap year
				daysInMonth = 29;
			} else {
				// Non-leap year
				daysInMonth = 28;
			}
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			// April, June, September, November
			daysInMonth = 30;
		} else {
			// All other months
			daysInMonth = 31;
		}

		// If the day was between 1 and 31 it will return true
		if (day >= 1 && day <= daysInMonth) {
			return true;
		} else {
			lbl.setText("The date is invalid, check the date format (MM/DD/YYYY)");
			return false;
		}

	}

	// Method that switch the case to the main window
	private void returnMain(Stage stage) {
		stage.setScene(sceneMain);
		if (bdPane.getCenter() != vBoxMain)
			bdPane.setCenter(vBoxMain);
		stage.setTitle("Main Window");
		stage.show();
	}

	// Method that clears all the textFields and organize the nodes
	private void clear() {
		txtMartName.clear();
		txtMartAge.clear();
		txtMartDis.clear();
		txtMartLoc.clear();
		txtMartDate.clear();
		datePicker.setValue(null);
		disCmBox.setValue(null);
		locCmBox.setValue(null);
		locCmBox.setDisable(true);
		rbMale.setSelected(false);
		rbFemale.setSelected(false);
		rbUnknown.setSelected(false);
		lblMartInstInfo.setText("");
		lblMartInstInfo.setVisible(false);
	}

	// Method that checks if the string was a digit or not
	private boolean isNumeric(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	// Method that checks if the string contains any numeric character
	private boolean containsNumeric(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	// Method to sort the content of a ComboBox alphabetically ignoring case
	public void sortComboBoxAlphabetically(ComboBox<String> comboBox) {
		ObservableList<String> itemsList = FXCollections.observableArrayList(comboBox.getItems());

		// Sort the items alphabetically ignoring case
		Collections.sort(itemsList, String.CASE_INSENSITIVE_ORDER);

		// Clear the ComboBox and add the sorted items back
		comboBox.getItems().setAll(itemsList);
	}

	private void MartUpdButton(Stage primaryStage, MartyrLinkedList martyrList, BSTDistrictNode districtNode) {
		// Organize the nodes on the scene
		if (bdPane.getCenter() != vBoxInstMart)
			bdPane.setCenter(vBoxInstMart);

		gdPane1.getChildren().clear();
		gdPane1.add(lblMartName, 0, 0);
		gdPane1.add(txtMartName, 1, 0);
		gdPane1.add(lblMartAge, 0, 1);
		gdPane1.add(txtMartAge, 1, 1);
		gdPane1.add(lblMartGender, 0, 2);
		gdPane1.add(hBox1, 1, 2);

		primaryStage.show();
		lblMartInstInfo.setText("");
		lblMartInstInfo.setVisible(false);
		btMartUpd.setVisible(true);
		btMartInst.setText("Update");

		btMartInstMain.setOnAction(e -> returnMain(primaryStage));

		btMartClear.setOnAction(e -> clear());

		btMartInst.setOnAction(e2 -> {
			String name;
			// If all fields were empty it will inform the user
			if (txtMartName.getText().trim().isEmpty() && txtMartAge.getText().isEmpty()) {
				lblMartInstInfo.setVisible(true);
				lblMartInstInfo.setText("Fileds are empty");
				return;
			}
			// If the name was empty it will inform the user
			if (txtMartName.getText().trim().isEmpty()) {
				lblMartInstInfo.setVisible(true);
				lblMartInstInfo.setText("Name is empty");
				return;
			} else {
				name = txtMartName.getText();
			}

			byte age = -2;
			try {
				// If the age was empty it will inform the user
				if (txtMartAge.getText().trim().isEmpty()) {
					age = -1;
					lblMartInstInfo.setVisible(true);
					lblMartInstInfo.setText("Warning: Age is empty!");
				} else {
					age = Byte.parseByte(txtMartAge.getText());
					if (age < 0) {
						lblMartInstInfo.setVisible(true);
						lblMartInstInfo.setText("Age must be greater or equal to zero!");
						return;
					}
				}
			} catch (NumberFormatException e1) {
				lblMartInstInfo.setVisible(true);
				lblMartInstInfo.setText("Please an integer for the age not a string!");
				return;
			}

			char gender = '?';

			if (rbMale.isSelected())
				gender = 'M';
			else if (rbFemale.isSelected())
				gender = 'F';
			else if (rbUnknown.isSelected())
				gender = 'N';

			// If all fields were entered correctly it will add the new martyr
			if (!name.isEmpty() && (age >= 0 || age == -1)) {
				// If no gender was selected it will throw an exception
				if (gender != 'M' && gender != 'F' && gender != 'N') {
					lblMartInstInfo.setVisible(true);
					lblMartInstInfo.setText("Choose a gender!");
					return;
				}
			}
			// If the martyr wasn't found in any other district, update it
			if (!districtTree.searchMartyr(new Martyr(name, age, gender), lblMartInstInfo)) {
				// Confirmation dialog for updating martyr information
				Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
				confirmation.setTitle("Confirm Update Martyr");
				confirmation.setHeaderText("Update Martyr Information?");
				confirmation.setContentText("This will update '" + txtOldMartUpd.getText() + "' information.");
				Optional<ButtonType> updateResult = confirmation.showAndWait();

				if (updateResult.isPresent() && updateResult.get() == ButtonType.OK) {
					lblMartInstInfo.setVisible(true);
					districtTree.updateMartyr(districtNode, martyrList, txtOldMartUpd.getText(),
							new Martyr(name, age, gender), txtAreaDisNavigation, lblMartInstInfo);
				}
			} else { // Notify the user that the martyr already exist
				lblMartInstInfo.setVisible(true);
				lblMartInstInfo.setText(name + " already exist!");
			}
		});
	}

	private void showAlert(Alert.AlertType alertType, String headerText, String contentText) {
		Alert alert = new Alert(alertType);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		alert.showAndWait();
	}

	public static void main(String[] args) {
		launch(args);
	}
}