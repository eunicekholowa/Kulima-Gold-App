package com.example.kulimagoldapplication.Domain;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class ProductDomain implements Serializable {
        private String title;
        private String pic;
        private String description;
        private Double fee;
        private int numberIncard;


        public ProductDomain(String title, String pic, String description) {
                this.title = title;
                this.pic = pic;
                this.description = description;
                this.fee = fee;
        }
        public ProductDomain(String title, String pic, String description, Double fee) {
                this.title = title;
                this.pic = pic;
                this.description = description;
                this.fee = fee;
                this.numberIncard = numberIncard;
        }
        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getPic() {
                return pic;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public int getNumberIncard() {
                return numberIncard;
        }

        public void setNumberIncard(int numberIncard) {
                this.numberIncard = numberIncard;
        }

        public Double getFee() {
                return fee;
        }

        public void setFee(Double fee) {
                this.fee = fee;
        }


}
