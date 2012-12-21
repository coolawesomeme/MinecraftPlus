// Date: 12/13/2012 8:08:12 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package net.minecraftplus_mod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLeprechaun extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer hat1;
    ModelRenderer hat2;
  
  public ModelLeprechaun()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-2F, -4F, -2F, 4, 4, 4);
      head.setRotationPoint(0F, 8F, 0F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 11, 10);
      body.addBox(-3F, 0F, -1F, 6, 8, 2);
      body.setRotationPoint(0F, 8F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 28, 10);
      rightarm.addBox(-2F, 0F, -1F, 2, 8, 2);
      rightarm.setRotationPoint(-3F, 8F, 0F);
      rightarm.setTextureSize(64, 32);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      leftarm = new ModelRenderer(this, 28, 10);
      leftarm.addBox(0F, 0F, -1F, 2, 8, 2);
      leftarm.setRotationPoint(3F, 8F, 0F);
      leftarm.setTextureSize(64, 32);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 10);
      rightleg.addBox(-2F, 0F, -1F, 3, 8, 2);
      rightleg.setRotationPoint(-1F, 16F, 0F);
      rightleg.setTextureSize(64, 32);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 10);
      leftleg.addBox(-1F, 0F, -1F, 3, 8, 2);
      leftleg.setRotationPoint(1F, 16F, 0F);
      leftleg.setTextureSize(64, 32);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      hat1 = new ModelRenderer(this, 17, 0);
      hat1.addBox(-3F, 0F, -3F, 6, 1, 6);
      hat1.setRotationPoint(0F, 3F, 0F);
      hat1.setTextureSize(64, 32);
      hat1.mirror = true;
      setRotation(hat1, 0F, 0F, 0F);
      hat2 = new ModelRenderer(this, 42, 0);
      hat2.addBox(-2F, 0F, -2F, 4, 2, 4);
      hat2.setRotationPoint(0F, 1F, 0F);
      hat2.setTextureSize(64, 32);
      hat2.mirror = true;
      setRotation(hat2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
    hat1.render(f5);
    hat2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity par7Entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}
