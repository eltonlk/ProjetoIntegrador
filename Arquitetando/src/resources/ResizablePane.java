/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author nyko-
 */
public class ResizablePane {

    private final AnchorPane wrapper;
    private final Node content;
    private int width = 0;
    private int height = 0;
    private boolean fixed = false;
    private double top = 0;
    private double right = 0;
    private double bottom = 0;
    private double left = 0;

    public ResizablePane(AnchorPane wrapper, Node content) {
        this.wrapper = wrapper;
        this.content = content;
    }

    public ResizablePane fixedSize(int width, int height) {
        this.fixed = true;
        this.width = width;
        this.height = height;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.left = 0;

        setResizableListner();

        return this;
    }

    public ResizablePane responsive(double top, double right, double bottom, double left) {
        this.fixed = false;
        this.width = 0;
        this.height = 0;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;

        setResizableListner();

        return this;
    }

    public ResizablePane touch() {
        setContentPosition();

        return this;
    }

    private void setResizableListner() {
        this.wrapper.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                setContentPosition();
            }
        });

        this.wrapper.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                setContentPosition();
            }
        });

    }

    private void setContentPosition() {
        double topPadding = this.top;
        double rightPadding = this.right;
        double bottomPadding = this.bottom;
        double leftPadding = this.left;

        if (fixed) {
            double x = this.wrapper.getWidth() - this.width;
            double y = this.wrapper.getHeight() - this.height;

            topPadding = y / 2;
            rightPadding = x / 2;
            bottomPadding = y / 2;
            leftPadding = x / 2;
        }

        AnchorPane.setTopAnchor(this.content, topPadding);
        AnchorPane.setRightAnchor(this.content, rightPadding);
        AnchorPane.setBottomAnchor(this.content, bottomPadding);
        AnchorPane.setLeftAnchor(this.content, leftPadding);
    }

}
